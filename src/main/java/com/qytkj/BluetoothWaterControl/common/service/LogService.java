package com.qytkj.BluetoothWaterControl.common.service;

import com.qytkj.BluetoothWaterControl.common.domain.LogDO;
import com.qytkj.BluetoothWaterControl.common.domain.PageDO;
import com.qytkj.BluetoothWaterControl.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
