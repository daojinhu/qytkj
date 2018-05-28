/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.common 
 * @author: hudaojin   
 * @date: 2018年5月16日 下午3:19:22 
 */
package com.qytkj.BluetoothWaterControl.operation.common;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.net.URL;  
import java.net.URLConnection; 

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/** 
* @Description: http请求工具类
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月16日 下午3:19:22 
*/
public class HttpUtil {

	private final static int CONNECT_TIMEOUT = 5000; // in milliseconds    
    private final static String DEFAULT_ENCODING = "UTF-8";    

    public static String postData(String urlStr, String data){    
        return postData(urlStr, data, null);    
    }    

    public static String postData(String urlStr, String data, String contentType){    
        BufferedReader reader = null;    
        try {    
            URL url = new URL(urlStr);    
            URLConnection conn = url.openConnection();    
            conn.setDoOutput(true);    
            conn.setConnectTimeout(CONNECT_TIMEOUT);    
            conn.setReadTimeout(CONNECT_TIMEOUT);    
            if(contentType != null)    
                conn.setRequestProperty("content-type", contentType);    
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);    
            if(data == null)    
                data = "";    
            writer.write(data);     
            writer.flush();    
            writer.close();      

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));    
            StringBuilder sb = new StringBuilder();    
            String line = null;    
            while ((line = reader.readLine()) != null) {    
                sb.append(line);    
                sb.append("\r\n");    
            }    
            return sb.toString();    
        } catch (IOException e) {    
            //logger.error("Error connecting to " + urlStr + ": " + e.getMessage());    
        } finally {    
            try {    
                if (reader != null)    
                    reader.close();    
            } catch (IOException e) {    
            }    
        }    
        return null;    
    }  
    
    /**
    *
    * @param path 拼接好的小程序URL
    * @return 微信返回的数据结果
    */
   public static String httpGet(String path) {
       //判断传递是否为空
       if (path == null)
            return null;
       //定义rec接收微信的返回值
       String rec = null;
       HttpGet get = new HttpGet(path);
       try {
           HttpResponse response = HttpClients.createDefault().execute(get);
           HttpEntity entity = response.getEntity();
           rec = EntityUtils.toString(entity);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return rec;
   }

}
