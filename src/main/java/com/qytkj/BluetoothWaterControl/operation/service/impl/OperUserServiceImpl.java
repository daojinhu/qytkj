/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.service.impl 
 * @author: hudaojin   
 * @date: 2018年5月9日 上午11:48:42 
 */
package com.qytkj.BluetoothWaterControl.operation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qytkj.BluetoothWaterControl.operation.dao.OperUserDao;
import com.qytkj.BluetoothWaterControl.operation.domain.OperAddressDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperUserDO;
import com.qytkj.BluetoothWaterControl.operation.service.OperUserService;

/** 
* @ClassName: OperUserServiceImpl.java
* @Description: 运维端业务实现类
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月9日 上午11:48:42 
*
*/
@Service
public class OperUserServiceImpl implements OperUserService {

	@Autowired
	private OperUserDao operUserDao;
	@Override
	public OperUserDO findUserByAccountAndPass(String account, String password) {
		
		return operUserDao.findUserByAccountAndPass(account, password);
	}
	
	/** 
	* @Description: 查询运维账户信息
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public List<OperUserDO> queryOperUser() {
		
		return operUserDao.queryOperUser();
	}

	/** 
	* @Description: 获取学校名称
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public List<OperAddressDO> queryOperAddress() {
		
		return operUserDao.queryAddress();
	}

	/** 
	* @Description: 修改运维账户密码
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public Integer updatePassword(String account, String password) {
		
		return operUserDao.updatePassword(account,password);
	}

	
}
