/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.domain 
 * @author: hudaojin   
 * @date: 2018年5月14日 下午4:06:05 
 */
package com.qytkj.BluetoothWaterControl.operation.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
* @Description: 订单详情
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月14日 下午4:06:05 
*/
public class OperOrderDO implements Serializable {

	private static final long serialVersionUID = 1L;

	//主键ID
	private Integer id;
	//设备ID
	private Integer deviceId;
	//用户手机号
	private Integer customerPhone;
	//设备位置
	private String address;
	//订单号
	private String orderNO;
	//支付方式
	private String paymentMode;
	//实际消费金额
	private BigDecimal consumption;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(Integer customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public BigDecimal getConsumption() {
		return consumption;
	}
	public void setConsumption(BigDecimal consumption) {
		this.consumption = consumption;
	}
	
}
