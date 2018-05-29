/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.dao 
 * @author: hudaojin   
 * @date: 2018年5月14日 上午11:56:31 
 */
package com.qytkj.BluetoothWaterControl.operation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qytkj.BluetoothWaterControl.operation.domain.OperOrderDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperRepairDO;

/** 
* @Description: 设备报修数据访问层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月14日 上午11:56:31 
*/
public interface OperRepairDao {

	//获取设备报修信息
	List<OperRepairDO> queryOperRepair();
	//获取设备报修信息(已报修)
	List<OperRepairDO> queryOperRepairFinish();
	//根据id，维修人员账号获取设备报修信息(已报修)
	List<OperRepairDO> queryOperRepairFinById(@Param("rid") int rid, @Param("maintainPerson") String maintainPerson);
	//获取订单详情
	OperOrderDO queryOperOrderById(int deviceId);
	
}
