/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.service 
 * @author: hudaojin   
 * @date: 2018年5月9日 上午11:47:54 
 */
package com.qytkj.BluetoothWaterControl.operation.service;

import java.util.List;

import com.qytkj.BluetoothWaterControl.operation.domain.OperAddressDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperUserDO;

/** 
* @ClassName: OperUserService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月9日 上午11:47:54 
*/
public interface OperUserService {

	/**
	 * 
	* @Description: 验证登录
	*
	* @param:账号，密码
	* @return：返回结果描述
	* @throws：异常描述
	 */
	OperUserDO findUserByAccountAndPass(String account, String password);
	
	//获取运维人员信息
	List<OperUserDO> queryOperUser();
	//获取学校名称
	List<OperAddressDO> queryOperAddress();
	//修改密码
	Integer updatePassword(String account, String password);
}
