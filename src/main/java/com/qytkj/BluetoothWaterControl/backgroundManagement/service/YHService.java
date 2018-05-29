/**  
* <p>Title: YWService.java</p>  
* @author sj
* @date 2018年5月26日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.DeptDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YHDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.vo.YHUserVO;
import com.qytkj.BluetoothWaterControl.common.domain.Tree;

/**
 * 用户类_Service层
 * @author sj
 * @date 2018年5月26日 
 */
@Service
public interface YHService {
	YHDO get(Long id);

	List<YHDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int update(YHDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);
	
	int adminResetPwd(YHUserVO userVO) throws Exception;
	
	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(YHDO YHDO);

}
