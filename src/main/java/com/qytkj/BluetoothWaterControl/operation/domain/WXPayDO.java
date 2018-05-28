/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.domain 
 * @author: hudaojin   
 * @date: 2018年5月21日 上午10:46:31 
 */
package com.qytkj.BluetoothWaterControl.operation.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/** 
* @Description: 微信小程序支付实体类
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月21日 上午10:46:31 
*/

@Component
public class WXPayDO implements Serializable {

	private static final long serialVersionUID = 1L;

	//主键ID
	private Integer id;
	//商户订单号
	private String outTradeNo;
	//支付时间戳
	private String timestamp;
	//商品ID
	private String goodsId;
	//用户的唯一标识
	private String openId;
	//创建时间
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
}
