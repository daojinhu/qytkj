/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.service 
 * @author: hudaojin   
 * @date: 2018年5月14日 上午11:57:20 
 */
package com.qytkj.BluetoothWaterControl.operation.service;

import java.util.List;

import com.qytkj.BluetoothWaterControl.operation.domain.OperOrderDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperRepairDO;

/** 
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月14日 上午11:57:20 
*/
public interface OperRepairService {

	//获取设备报修信息
	List<OperRepairDO> queryOperRepair();
	//获取订单详情
	OperOrderDO queryOperOrderById(Integer deviceId);
}
