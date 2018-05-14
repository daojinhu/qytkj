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
	* @Description: 获取设备报修信息
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
