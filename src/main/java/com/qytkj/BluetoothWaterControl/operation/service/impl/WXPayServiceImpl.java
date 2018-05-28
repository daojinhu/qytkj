package com.qytkj.BluetoothWaterControl.operation.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qytkj.BluetoothWaterControl.operation.dao.WXPayDao;
import com.qytkj.BluetoothWaterControl.operation.domain.WXPayDO;
import com.qytkj.BluetoothWaterControl.operation.service.WXPayService;

/** 
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月21日 下午2:08:15 
*/
@Service
public class WXPayServiceImpl implements WXPayService {

	@Autowired
	private WXPayDao wXPayDao;
	@Override
	public boolean addWXPayInfo(WXPayDO wxPayDO) {
		
		if (wxPayDO.getOutTradeNo() != null && !"".equals(wxPayDO.getOutTradeNo())) {
			wxPayDO.setCreateTime(new Date());
			try {
				int effectedNum = wXPayDao.addWXPayInfo(wxPayDO);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加微信小程序支付信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加微信小程序支付信息失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("微信小程序支付信息不能为空！");
		}
	}

}
