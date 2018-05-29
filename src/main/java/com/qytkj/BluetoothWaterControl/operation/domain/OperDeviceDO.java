/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.domain 
 * @author: hudaojin   
 * @date: 2018年5月12日 上午10:30:41 
 */
package com.qytkj.BluetoothWaterControl.operation.domain;

import java.io.Serializable;
import java.util.Date;

/** 
* @Description: 添加设备实体类
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月12日 上午10:30:41 
*/
public class OperDeviceDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//设备名称
	private String deviceName;
	//设备类型
	private Integer deviceType;
	//学校
	private String school;
	//设备位置
	private String address;
	//楼栋
	private String building; 
	//楼层
	private String floor;
	//宿舍
	private String dormitory;
	//供应商
	private String supplier;
	//费率
	private String rate;
	//自动关阀时间
	private String closeTime;
	//创建时间	
	private Date createTime;
	//更新时间
	private Date lastEditTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}	
	
}
