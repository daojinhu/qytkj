/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.domain 
 * @author: hudaojin   
 * @date: 2018年5月9日 下午3:09:46 
 */
package com.qytkj.BluetoothWaterControl.operation.domain;

import java.io.Serializable;
import java.math.*;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
* @ClassName: OperUserDO.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月9日 下午3:09:46 
*
*/
public class OperUserDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//运维账号
	private String vchrAccout;
	//密码
	private String vchrPassword;
	//状态
	private Integer intStatus;
	//昵称
	private String vchrNickname;
	//账户余额
	private BigDecimal decAccountBalance;
	//管理的地址
	private String vchrAddress;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	//修改时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVchrAccout() {
		return vchrAccout;
	}
	public void setVchrAccout(String vchrAccout) {
		this.vchrAccout = vchrAccout;
	}
	public String getVchrPassword() {
		return vchrPassword;
	}
	public void setVchrPassword(String vchrPassword) {
		this.vchrPassword = vchrPassword;
	}
	public Integer getIntStatus() {
		return intStatus;
	}
	public void setIntStatus(Integer intStatus) {
		this.intStatus = intStatus;
	}
	public String getVchrNickname() {
		return vchrNickname;
	}
	public void setVchrNickname(String vchrNickname) {
		this.vchrNickname = vchrNickname;
	}
	public BigDecimal getDecAccountBalance() {
		return decAccountBalance;
	}
	public void setDecAccountBalance(BigDecimal decAccountBalance) {
		this.decAccountBalance = decAccountBalance;
	}
	public String getVchrAddress() {
		return vchrAddress;
	}
	public void setVchrAddress(String vchrAddress) {
		this.vchrAddress = vchrAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
