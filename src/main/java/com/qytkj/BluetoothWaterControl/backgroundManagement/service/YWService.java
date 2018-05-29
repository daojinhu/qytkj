/**  
* <p>Title: YWService.java</p>  
* @author sj
* @date 2018年5月24日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.DeptDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YWDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.vo.YWUserVO;
import com.qytkj.BluetoothWaterControl.common.domain.Tree;

/**
 * @author sj
 * @date 2018年5月24日 
 */
@Service
public interface YWService {
	YWDO get(Long id);

	List<YWDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(YWDO user);

	int update(YWDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);
	
	int adminResetPwd(YWUserVO userVO) throws Exception;
	
	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(YWDO ywDO);

}
