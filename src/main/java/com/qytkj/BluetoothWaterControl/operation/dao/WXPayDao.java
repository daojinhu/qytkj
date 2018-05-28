package com.qytkj.BluetoothWaterControl.operation.dao;

import org.apache.ibatis.annotations.Mapper;

import com.qytkj.BluetoothWaterControl.operation.domain.WXPayDO;

/** 
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月21日 下午2:10:27 
*/
@Mapper
public interface WXPayDao {

	//添加微信小程序支付信息
	int addWXPayInfo(WXPayDO wxPayDO);
}
