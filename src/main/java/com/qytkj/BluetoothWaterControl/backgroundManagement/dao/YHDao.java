/**  
* <p>Title: YWDao.java</p>  
* @author sj
* @date 2018年5月24日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YHDO;

/**
 * 用户类_持久层
 * @author sj
 * @date 2018年5月24日 
 */
@Mapper
public interface YHDao {

		YHDO get(Long id);
		
		List<YHDO> list(Map<String,Object> map);
		
		int count(Map<String,Object> map);
		
		int update(YHDO user);
		
		int remove(Long userId);
		
		int batchRemove(Long[] userIds);
		
		Long[] listAllDept();

}
