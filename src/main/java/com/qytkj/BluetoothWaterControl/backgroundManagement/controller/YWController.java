/**  
* <p>Title: YWController.java</p>  
* @author sj
* @date 2018年5月23日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.DeptDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.RoleDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YWDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.RoleService;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.YWService;
import com.qytkj.BluetoothWaterControl.common.annotation.Log;
import com.qytkj.BluetoothWaterControl.common.controller.BaseController;
import com.qytkj.BluetoothWaterControl.common.domain.Tree;
import com.qytkj.BluetoothWaterControl.common.config.Constant;
import com.qytkj.BluetoothWaterControl.common.service.DictService;
import com.qytkj.BluetoothWaterControl.common.utils.MD5Utils;
import com.qytkj.BluetoothWaterControl.common.utils.PageUtils;
import com.qytkj.BluetoothWaterControl.common.utils.Query;
import com.qytkj.BluetoothWaterControl.common.utils.R;

/**
 * @author sj
 * @date 2018年5月23日 
 */
@RequestMapping("/backStage/yw")
@Controller
public class YWController extends BaseController {
	private String prefix="backStage/yw"  ;
	@Autowired
	YWService ywService;
	@Autowired
    RoleService roleService;
	@Autowired
    DictService dictService;
	
/*@RequiresPermissions("sys:user:user")*/
	@Log("跳转到列表主页")
	@GetMapping("")
	String user(Model model) {
		return prefix + "/user";
	}
	
	@Log("获取用户列表")
	@GetMapping("/list")
	@ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<YWDO> sysUserList = ywService.list(query);
		int total = ywService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}
	
/*@RequiresPermissions("sys:user:add")*/
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		List<RoleDO> roles = roleService.list();
		model.addAttribute("roles", roles);
		return prefix + "/add";
	}
	  
/*@RequiresPermissions("sys:user:edit")*/
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		YWDO YWDO = ywService.get(id);
		model.addAttribute("user", YWDO);
		List<RoleDO> roles = roleService.list(id);
		model.addAttribute("roles", roles);
		return prefix+"/edit";
	}
	
/*@RequiresPermissions("sys:user:add")*/
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
    R save(YWDO user) throws Exception {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		user.setStrPassword(MD5Utils.MD5Encode(user.getStrPassword()));
		if (ywService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
/*@RequiresPermissions("sys:user:edit")*/
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	R update(YWDO user) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		if (ywService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
/*	@RequiresPermissions("sys:user:remove")*/
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		if (ywService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
/*@RequiresPermissions("sys:user:batchRemove")*/
	@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}

		int r = ywService.batchremove(userIds);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	@Log("账号唯一验证")
	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !ywService.exit(params);
	}
	
/*@RequiresPermissions("sys:user:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {	
		YWDO userDO = new YWDO();
		userDO.setIntId(userId);
		model.addAttribute("user", userDO);
		return prefix + "/reset_pwd";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(YWUserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getYWUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		try{
			ywService.resetPwd(userVO,getUser());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}
	}*/
	
/*@RequiresPermissions("sys:user:resetPwd")
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(YWUserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		try{
			ywService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}
	}*/
	
	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = ywService.getTree();
		return tree;
	}
	
	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	

}
