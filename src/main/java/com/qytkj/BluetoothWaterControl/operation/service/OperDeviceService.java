package com.qytkj.BluetoothWaterControl.operation.service;

import java.util.List;

import com.qytkj.BluetoothWaterControl.operation.domain.OperDeviceDO;

/** 
* @Description: 设备管理业务逻辑层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月25日 下午2:57:30 
*/
public interface OperDeviceService {

	//添加设备信息
	boolean addDevice(OperDeviceDO operDeviceDO);
	//获取设备信息
	List<OperDeviceDO> queryOperDevice();
	//根据id获取设备信息
	List<OperDeviceDO> queryOperDeviceById(int rid);
	//修改设备信息
	boolean modifyOperDevice(OperDeviceDO operDeviceDO);
	//删除设备信息
	boolean deleteOperDevice(int id);
}
