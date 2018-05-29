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

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YWDO;

/**
 * @author sj
 * @date 2018年5月24日 
 */
@Mapper
public interface YWDao {

		YWDO get(Long id);
		
		List<YWDO> list(Map<String,Object> map);
		
		int count(Map<String,Object> map);
		
		int save(YWDO user);
		
		int update(YWDO user);
		
		int remove(Long userId);
		
		int batchRemove(Long[] userIds);
		
		Long[] listAllDept();

}
