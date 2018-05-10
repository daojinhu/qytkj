/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.controller 
 * @author: hudaojin   
 * @date: 2018年5月9日 上午11:40:47 
 */
package com.qytkj.BluetoothWaterControl.operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qytkj.BluetoothWaterControl.operation.domain.OperAddressDO;
import com.qytkj.BluetoothWaterControl.operation.domain.OperUserDO;
import com.qytkj.BluetoothWaterControl.operation.service.OperUserService;

/** 
* @ClassName: OperUserController.java
* @Description: 运维端用户控制层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月9日 上午11:40:47 
*/
@RestController
@RequestMapping("/operUser")
public class OperUserController {

	@Autowired
	private OperUserService operUserService;
	/**
	 * @param 登录校验
	 * @return return 1 用户名或密码为空||return 2用户名或密码错误||return 3 登录成功
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password,HttpSession session){
		System.out.println(username+"--"+password);
		if(username == null || username.trim() == "" || password == null || password.trim() == ""){
			return "1";
		}
		
		OperUserDO operUser = operUserService.findUserByAccountAndPass(username.trim(), password.trim());
		if(operUser != null){			
			session.setAttribute("operUser", operUser);
			return "3";
		}
		return "2";
	}
	
	/**
	 * 
	* @Description: 获取运维用户信息
	*
	* @param:描述1描述
	* @return：用户信息
	* @throws：异常描述
	 */
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	public Map<String, Object> getUser(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperUserDO> list = operUserService.queryOperUser();
		modelMap.put("operUserList", list);
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 获取所有学校名称
	*
	* @param:描述1描述
	* @return：学校列表
	* @throws：异常描述
	 */
	@RequestMapping(value="/getAddress", method=RequestMethod.GET)
	public Map<String, Object> getAddress(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OperAddressDO> list = operUserService.queryOperAddress();
		modelMap.put("operAddressList", list);
		return modelMap;
	}
	
	/**
	 * 
	* @Description: 修改运维账户密码
	*
	* @param:账号，密码
	* @return：返回结果描述
	* @throws：异常描述
	 */
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
	public Integer updatePassword(@RequestParam("account")String account,
			@RequestParam("password")String password){
		int res = operUserService.updatePassword(account.trim(), password.trim());
		if(res == 1){
			return 1;
		}else{
			return 0;
		}	
	}
}
