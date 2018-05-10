/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.domain 
 * @author: hudaojin   
 * @date: 2018年5月10日 上午8:40:49 
 */
package com.qytkj.BluetoothWaterControl.operation.domain;

import java.io.Serializable;

/** 
* @ClassName: OperAddressDO.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月10日 上午8:40:49 
*/
public class OperAddressDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//学校名称
	private String vchrAddress;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVchrAddress() {
		return vchrAddress;
	}
	public void setVchrAddress(String vchrAddress) {
		this.vchrAddress = vchrAddress;
	}
	
	
}
