/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.service 
 * @author: hudaojin   
 * @date: 2018年5月23日 上午11:05:08 
 */
package com.qytkj.BluetoothWaterControl.operation.service;

import com.qytkj.BluetoothWaterControl.operation.domain.WXPayDO;

/** 
* @ClassName: WXMiroPayService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月23日 上午11:05:08 
*/
public interface WXPayService {

	//添加微信小程序支付信息
	boolean addWXPayInfo(WXPayDO wxPayDO);
}
