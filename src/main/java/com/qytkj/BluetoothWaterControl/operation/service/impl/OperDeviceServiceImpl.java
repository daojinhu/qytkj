package com.qytkj.BluetoothWaterControl.operation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qytkj.BluetoothWaterControl.operation.dao.OperDeviceDao;
import com.qytkj.BluetoothWaterControl.operation.domain.OperDeviceDO;
import com.qytkj.BluetoothWaterControl.operation.service.OperDeviceService;

/** 
* @Description: 设备管理业务实现层
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月25日 下午2:58:54 
*/
@Service
public class OperDeviceServiceImpl implements OperDeviceService {

	@Autowired
	private OperDeviceDao operDeviceDao;
	
	/**
	 * @Description: 添加设备
	 *
	 * @param:设备相关信息
	 * @return：boolean
	 * @throws：添加设备信息失败，设备信息不能为空
	 */
	@Override
	public boolean addDevice(OperDeviceDO operDeviceDO) {
		if (operDeviceDO.getDeviceName() != null && !"".equals(operDeviceDO.getDeviceName())) {
			operDeviceDO.setCreateTime(new Date());
			operDeviceDO.setLastEditTime(new Date());
			try {
				int effectedNum = operDeviceDao.addDevice(operDeviceDO);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加设备信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加设备信息失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("设备信息不能为空！");
		}
	}

	/**
	 * @Description: 获取设备信息
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 */
	@Override
	public List<OperDeviceDO> queryOperDevice() {

		return operDeviceDao.queryOperDevice();
	}

	/**
	 * @Description: 修改设备信息
	 *
	 * @param:设备信息实体类
	 * @return：返回boolean值
	 * @throws：异常描述
	 */
	@Override
	public boolean modifyOperDevice(OperDeviceDO operDeviceDO) {
		// 空值判断，主要是设备id不为空
		if (operDeviceDO.getId() != null && operDeviceDO.getId() > 0) {
			// 设置默认值
			operDeviceDO.setLastEditTime(new Date());
			try {
				int effectedNum = operDeviceDao.modifyOperDevice(operDeviceDO);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新设备信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新设备信息失败：" + e.toString());
			}
		} else {
			throw new RuntimeException("设备信息不能为空！");
		}
	}

	/**
	 * @Description: 删除设备信息
	 *
	 * @param:根据id删除
	 * @return：返回boolean值
	 * @throws：异常描述
	 */
	@Override
	public boolean deleteOperDevice(int id) {
		// 空值判断，主要是设备id不为空
		if (id > 0) {
			try {
				int effectedNum = operDeviceDao.deleteOperDevice(id);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("刪除设备信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("刪除设备信息失败：" + e.toString());
			}
		} else {
			throw new RuntimeException("设备ID不能为空！");
		}
	}

	/** 
	* @Description: 根据id获取设备信息
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public List<OperDeviceDO> queryOperDeviceById(int rid) {
		
		return operDeviceDao.queryOperDeviceById(rid);
	}

}
