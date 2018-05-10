/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.dao 
 * @author: hudaojin   
 * @date: 2018年5月9日 上午11:41:45 
 */
package com.qytkj.BluetoothWaterControl.operation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qytkj.BluetoothWaterControl.operation.domain.OperAddressDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperUserDO;

/** 
* @ClassName: OperUserDao.java
* @Description: 数据访问层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月9日 上午11:41:45 
*/
@Mapper
public interface OperUserDao {

	//验证登录
	OperUserDO findUserByAccountAndPass(@Param("account")String account, @Param("password")String password);
	//获取账户信息
	List<OperUserDO> queryOperUser();
	//获取所有学校名称
	List<OperAddressDO> queryAddress();
	//修改运维账户密码
	Integer updatePassword(@Param("account")String account, @Param("password")String password);
}
