package com.qytkj.BluetoothWaterControl.backgroundManagement.service;

import java.util.Collection;
import java.util.List;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.UserDO;
import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.UserOnline;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
	List<UserOnline> list();

	List<UserDO> listOnlineUser();

	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}
