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
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YHDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.YHService;
import com.qytkj.BluetoothWaterControl.backgroundManagement.vo.YHUserVO;
import com.qytkj.BluetoothWaterControl.common.annotation.Log;
import com.qytkj.BluetoothWaterControl.common.controller.BaseController;
import com.qytkj.BluetoothWaterControl.common.domain.Tree;
import com.qytkj.BluetoothWaterControl.common.config.Constant;
import com.qytkj.BluetoothWaterControl.common.service.DictService;
import com.qytkj.BluetoothWaterControl.common.utils.PageUtils;
import com.qytkj.BluetoothWaterControl.common.utils.Query;
import com.qytkj.BluetoothWaterControl.common.utils.R;

/**
 * @author sj
 * @date 2018年5月26日 
 */
@RequestMapping("/backStage/yh")
@Controller
public class YHController extends BaseController {
	private String prefix="backStage/yh"  ;
	@Autowired
	YHService yhService;
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
		List<YHDO> sysUserList = yhService.list(query);
		int total = yhService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}
	
/*@RequiresPermissions("sys:user:add")*/
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		return prefix + "/add";
	}
	  
/*@RequiresPermissions("sys:user:edit")*/
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		YHDO yhDO = yhService.get(id);
		model.addAttribute("user", yhDO);
		return prefix+"/edit";
	}
	
/*@RequiresPermissions("sys:user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
    R save(YHDO user) throws Exception {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		user.setVchrPassword(MD5Utils.MD5Encode(user.getVchrPassword()));
		if (yhService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}*/
	
/*@RequiresPermissions("sys:user:edit")*/
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	R update(YHDO user) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		if (yhService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
/*@RequiresPermissions("sys:user:remove")*/
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		if (yhService.remove(id) > 0) {
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

		int r = yhService.batchremove(userIds);
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
		return !yhService.exit(params);
	}
	
/*@RequiresPermissions("sys:user:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {	
		YHDO userDO = new YHDO();
		userDO.setId(userId);
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
	
 /*   @RequiresPermissions("sys:user:resetPwd")*/
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(YHUserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请获取权限");
		}
		try{
			yhService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}
	}
	
	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = yhService.getTree();
		return tree;
	}
	
	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	

}
