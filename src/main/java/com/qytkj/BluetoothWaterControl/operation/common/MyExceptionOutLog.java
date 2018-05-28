/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.common 
 * @author: hudaojin   
 * @date: 2018年5月16日 下午3:21:23 
 */
package com.qytkj.BluetoothWaterControl.operation.common;

/** 
* @Description: 异常日志类
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月16日 下午3:21:23 
*/
public class MyExceptionOutLog {

	public static String outLog(Exception e) {  
        String error = "";  
        StackTraceElement[] st = e.getStackTrace();  
        for (StackTraceElement stackTraceElement : st) {  
            String exclass = stackTraceElement.getClassName();  
            String method = stackTraceElement.getMethodName();  
            /*new Date() + ":" + */  
            error += "\t[类:" + exclass + "]调用"  
            + method + "时在第" + stackTraceElement.getLineNumber()  
            + "行代码处发生异常!\n\t\t\t异常类型:" + e.getClass().getName()  
            + "\n\t\t异常信息为:"+ e.toString()+"\n";  
        }  
          
        return error;  
    } 
}
