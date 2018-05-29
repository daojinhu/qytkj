/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.service.impl 
 * @author: hudaojin   
 * @date: 2018年5月14日 上午11:58:02 
 */
package com.qytkj.BluetoothWaterControl.operation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qytkj.BluetoothWaterControl.operation.dao.OperRepairDao;
import com.qytkj.BluetoothWaterControl.operation.domain.OperOrderDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperRepairDO;
import com.qytkj.BluetoothWaterControl.operation.service.OperRepairService;

/** 
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月14日 上午11:58:02 
*/
@Service
public class OperRepairServiceImpl implements OperRepairService {

	@Autowired
	private OperRepairDao operRepairDao;
	
	/** 
	* @Description: 获取设备报修信息
	* @return：list
	* @throws：异常描述
	*/
	@Override
	public List<OperRepairDO> queryOperRepair() {
		
		return operRepairDao.queryOperRepair();
	}
	
	/** 
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public List<OperRepairDO> queryOperRepairFinish() {
		
		return operRepairDao.queryOperRepairFinish();
	}	

	/** 
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public OperOrderDO queryOperOrderById(Integer deviceId) {
		
		return operRepairDao.queryOperOrderById(deviceId);
	}

	/** 
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public List<OperRepairDO> queryOperRepairFinById(int rid, String maintainPerson) {
		
		return operRepairDao.queryOperRepairFinById(rid, maintainPerson);
	}	

}
