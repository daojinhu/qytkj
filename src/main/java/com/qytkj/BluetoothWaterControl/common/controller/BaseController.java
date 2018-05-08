package com.qytkj.BluetoothWaterControl.common.controller;

import com.qytkj.BluetoothWaterControl.common.utils.ShiroUtils;
import org.springframework.stereotype.Controller;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}