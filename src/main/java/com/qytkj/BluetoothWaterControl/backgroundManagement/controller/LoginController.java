package com.qytkj.BluetoothWaterControl.backgroundManagement.controller;

import com.qytkj.BluetoothWaterControl.common.annotation.Log;
import com.qytkj.BluetoothWaterControl.common.controller.BaseController;
import com.qytkj.BluetoothWaterControl.common.domain.FileDO;
import com.qytkj.BluetoothWaterControl.common.domain.Tree;
import com.qytkj.BluetoothWaterControl.common.service.FileService;
import com.qytkj.BluetoothWaterControl.common.utils.R;
import com.qytkj.BluetoothWaterControl.common.utils.ShiroUtils;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.MenuDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MenuService menuService;
	@Autowired
	FileService fileService;

	@GetMapping({ "/", "" })
	String welcome(Model model) {
		return "redirect:/login";
	}

	@Log("请求访问主页")
	@GetMapping({ "/homePage" })
	String index(Model model) {
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		FileDO fileDO = fileService.get(getUser().getPicId());
		if(fileDO!=null&&fileDO.getUrl()!=null){
			if(fileService.isExist(fileDO.getUrl())){
				model.addAttribute("picUrl",fileDO.getUrl());
			}else {
				model.addAttribute("picUrl","/img/photo_s.jpg");
			}
		}else {
			model.addAttribute("picUrl","/img/photo_s.jpg");
		}
		model.addAttribute("username", getUser().getUsername());
		return "homePage";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
	R ajaxLogin(@RequestParam("username")String username,
				@RequestParam("password")String password) {

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (UnknownAccountException e) {
			return R.error("该用户不存在！");
		}catch(IncorrectCredentialsException e){
			return R.error("密码错误！");
		}catch(LockedAccountException e){
			return R.error("账号已被锁定,请联系管理员！");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

}
