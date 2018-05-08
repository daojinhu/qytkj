package com.qytkj.BluetoothWaterControl.backgroundManagement.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.qytkj.BluetoothWaterControl.common.config.ApplicationContextRegister;
import com.qytkj.BluetoothWaterControl.common.utils.ShiroUtils;
import com.qytkj.BluetoothWaterControl.backgroundManagement.dao.UserDao;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.UserDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.service.MenuService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
/*	@Autowired
	UserDao userMapper;
	@Autowired
	MenuService menuService;*/

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Long userId = ShiroUtils.getUserId();
		MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
		Set<String> perms = menuService.listPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Map<String, Object> map = new HashMap<>(16);
		map.put("username", username);
		String password = new String((char[]) token.getCredentials());

		UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);

		// 账号不存在
		if (userMapper.list(map).size() == 0) {
			throw new UnknownAccountException("该用户不存在！");
		}

		// 查询用户信息
		UserDO user = userMapper.list(map).get(0);

		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("密码不正确！");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员！");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
