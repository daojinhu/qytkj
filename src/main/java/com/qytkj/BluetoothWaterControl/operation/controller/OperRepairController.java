/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.controller 
 * @author: hudaojin   
 * @date: 2018年5月14日 上午11:55:45 
 */
package com.qytkj.BluetoothWaterControl.operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qytkj.BluetoothWaterControl.operation.domain.OperOrderDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperRepairDO;
import com.qytkj.BluetoothWaterControl.operation.service.OperRepairService;

/** 
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月14日 上午11:55:45 
*/
@RestController
@RequestMapping("/operUser")
public class OperRepairController {

	@Autowired
	private OperRepairService operRepairService;
	
	/**
	 * 
	* @Description: 获取设备报修信息(待办任务)
	* @return：map
	* @throws：异常描述
	 */
	@RequestMapping(value="/queryOperRepair", method=RequestMethod.GET)
	public Map<String, Object> queryOperRepair(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperRepairDO> list = operRepairService.queryOperRepair();
		modelMap.put("operRepairList", list);
		return modelMap;
	}
	
	/**
	* @Description: 获取设备报修信息(已完成任务)
	*
	* @return：map:finishOperRepairList
	* @throws：异常描述
	 */
	@RequestMapping(value="/queryOperRepairFinish", method=RequestMethod.GET)
	public Map<String, Object> queryOperRepairFinish(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperRepairDO> list = operRepairService.queryOperRepairFinish();
		modelMap.put("finishOperRepairList", list);
		return modelMap;
	}
	
	/**
	* @Description: 根据id，维修人员账号获取设备报修信息(已完成任务)
	*
	* @return：map:finishOperRepairByIdList
	* @throws：异常描述
	 */
	@RequestMapping(value="/queryOperRepairFinById", method=RequestMethod.POST)
	public Map<String, Object> queryOperRepairFinById(@RequestParam("rid") Integer rid, 
			@RequestParam("maintainPerson") String maintainPerson){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperRepairDO> list = operRepairService.queryOperRepairFinById(rid, maintainPerson);
		modelMap.put("finishOperRepairByIdList", list);
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 获取订单详情
	* @return：map
	* @throws：异常描述
	 */
	@RequestMapping(value="/queryOperOrderById", method=RequestMethod.POST)
	public Map<String, Object> queryOperOrderById(Integer deviceId){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		OperOrderDO operOrder = operRepairService.queryOperOrderById(deviceId);
		modelMap.put("operOrder", operOrder);
		return modelMap;
	}
	
}
