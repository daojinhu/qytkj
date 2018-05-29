/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.dao 
 * @author: hudaojin   
 * @date: 2018年5月25日 下午2:55:20 
 */
package com.qytkj.BluetoothWaterControl.operation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qytkj.BluetoothWaterControl.operation.domain.OperDeviceDO;

/** 
* @Description: 设备管理持久层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月25日 下午2:55:20 
*/
@Mapper
public interface OperDeviceDao {

	//添加设备
	int addDevice(OperDeviceDO operDeviceDO);
	//获取设备信息
	List<OperDeviceDO> queryOperDevice();
	//根据id获取设备信息
	List<OperDeviceDO> queryOperDeviceById(int rid);
	//修改设备信息
	int modifyOperDevice(OperDeviceDO operDeviceDO);
	//删除设备信息
	int deleteOperDevice(int id);	
}
