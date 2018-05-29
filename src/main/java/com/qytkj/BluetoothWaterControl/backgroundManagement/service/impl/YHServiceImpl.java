/**  
* <p>Title: YWServiceImpl.java</p>  
* @author sj
* @date 2018年5月24日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qytkj.BluetoothWaterControl.backgroundManagement.dao.DeptDao;
import com.qytkj.BluetoothWaterControl.backgroundManagement.dao.YHDao;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.DeptDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YHDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.UserService;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.YHService;
import com.qytkj.BluetoothWaterControl.backgroundManagement.vo.YHUserVO;
import com.qytkj.BluetoothWaterControl.common.domain.Tree;
import com.qytkj.BluetoothWaterControl.common.utils.BuildTree;
import com.qytkj.BluetoothWaterControl.common.utils.MD5Utils;

/**
 * @author sj
 * @date 2018年5月24日 
 */
@Transactional
@Service
public class YHServiceImpl implements YHService {

	@Autowired
    YHDao userMapper;
	@Autowired
    DeptDao deptMapper;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Override
	public YHDO get(Long id) {
		YHDO user = userMapper.get(id);
		user.setDeptName(deptMapper.get(user.getIntDeptId()).getName());
		return user;
	}

	@Override
	public List<YHDO> list(Map<String, Object> map) {
		List<YHDO> listUser = userMapper.list(map);
		for (YHDO yhdo : listUser) {
			yhdo.setDeptName(deptMapper.get(yhdo.getIntDeptId()).getName());		
		}
		return listUser;
	}

	@Override
	public int count(Map<String, Object> map) {
		return userMapper.count(map);
	}

	@Override
	public int update(YHDO user) {
		int r = userMapper.update(user);
		return r;
	}

	@Override
	public int remove(Long userId) {
		return userMapper.remove(userId);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = userMapper.list(params).size() > 0;
		return exit;
	}

	@Override
	public int adminResetPwd(YHUserVO userVO) throws Exception {
		YHDO userDO = get(userVO.getUserDO().getId());
		if("admin".equals(userDO.getVchrAccount())){
			throw new Exception("超级管理员的账号不允许直接重置！");
		}
		userDO.setVchrPassword(MD5Utils.MD5Encode(userVO.getPwdNew()));
		return userMapper.update(userDO);
	}

	@Transactional
	@Override
	public int batchremove(Long[] userIds) {
		int count = userMapper.batchRemove(userIds);
		return count;
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> depts = deptMapper.list(new HashMap<String, Object>(16));
		Long[] pDepts = deptMapper.listParentDept();
		Long[] uDepts = userMapper.listAllDept();
		Long[] allDepts = (Long[]) ArrayUtils.addAll(pDepts, uDepts);
		for (DeptDO dept : depts) {
			if (!ArrayUtils.contains(allDepts, dept.getDeptId())) {
				continue;
			}
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(dept.getDeptId().toString());
			tree.setParentId(dept.getParentId().toString());
			tree.setText(dept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			state.put("mType", "dept");
			tree.setState(state);
			trees.add(tree);
		}
		List<YHDO> users = userMapper.list(new HashMap<String, Object>(16));
		for (YHDO user : users) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(user.getId().toString());
			tree.setParentId(user.getIntDeptId().toString());
			tree.setText(user.getDeptName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			state.put("mType", "user");
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public int updatePersonal(YHDO userDO) {
		return userMapper.update(userDO);
	}

}
