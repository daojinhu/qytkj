package com.qytkj.BluetoothWaterControl.operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qytkj.BluetoothWaterControl.operation.domain.OperDeviceDO;
import com.qytkj.BluetoothWaterControl.operation.service.OperDeviceService;

/** 
* @Description: 设备管理控制层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月25日 下午2:53:02 
*/

@RestController
@RequestMapping("/operUser")
public class OperDeviceController {

	@Autowired
	private OperDeviceService operDeviceService;
	
	/**
	* @Description: 添加设备
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	 */
	@RequestMapping(value="/addDevice", method=RequestMethod.POST)
	public Map<String, Object> addDevice(@RequestBody OperDeviceDO operDeviceDO){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", operDeviceService.addDevice(operDeviceDO));
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 获取设备信息列表
	*
	* @return：返回设备列表
	* @throws：异常描述
	 */
	@RequestMapping(value="/queryOperDevice", method=RequestMethod.GET)
	public Map<String, Object> queryOperDevice(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperDeviceDO> list = operDeviceService.queryOperDevice();
		modelMap.put("operDeviceList", list);
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 根据id获取设备信息列表
	*
	* @return：返回设备列表
	* @throws：异常描述
	 */
	@RequestMapping(value="/queryOperDeviceById", method=RequestMethod.POST)
	public Map<String, Object> queryOperDeviceById(@RequestParam("rid") Integer rid){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperDeviceDO> list = operDeviceService.queryOperDeviceById(rid);
		modelMap.put("operDeviceListById", list);
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 修改设备信息
	*
	* @param:设备信息实体类
	* @return：map
	* @throws：异常描述
	 */
	@RequestMapping(value="/modifyOperDevice", method=RequestMethod.POST)
	public Map<String, Object> modifyOperDevice(@RequestBody OperDeviceDO operDeviceDO){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", operDeviceService.modifyOperDevice(operDeviceDO));
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 删除设备信息
	*
	* @param:id
	* @return：map
	* @throws：异常描述
	 */
	@RequestMapping(value="/deleteOperDevice")
	public Map<String, Object> deleteOperDevice(Integer id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", operDeviceService.deleteOperDevice(id));
		return modelMap;
	}
}
