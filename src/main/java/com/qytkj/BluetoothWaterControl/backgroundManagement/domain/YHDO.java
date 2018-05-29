/**  
* <p>Title: YWDo.java</p>  
* @author sj
* @date 2018年5月24日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户APP的用户实体类
 * 对应数据表 yh_tbluser
 * @author  sj
 * @Date 2018年05月24日上午9:36:23
 */
public class YHDO implements Serializable{
    private static final long serialVersionUID = 1L;
    
	private Long id;//用户ID（以及唯一身份识别）
	private String vchrAccount;//登录名
	private String vchrPassword;//登录密码
	private String vchrNickname;//真实姓名
	private Integer intSex;//性别
	private Integer intStatus;//状态
	private String vchrPhotoURL;//头像路径
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateCreateTime;//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateLastLoginTime;//上次登陆时间
	private BigDecimal decAccoundBalance;//账户余额
	private String vchrAddress;//地址
	private Long intDeptId;//所属部门
	private String deptName;//部门名称
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVchrAccount() {
		return vchrAccount;
	}
	public void setVchrAccount(String vchrAccount) {
		this.vchrAccount = vchrAccount;
	}
	public String getVchrPassword() {
		return vchrPassword;
	}
	public void setVchrPassword(String vchrPassword) {
		this.vchrPassword = vchrPassword;
	}
	public String getVchrNickname() {
		return vchrNickname;
	}
	public void setVchrNickname(String vchrNickname) {
		this.vchrNickname = vchrNickname;
	}
	public Integer getIntSex() {
		return intSex;
	}
	public void setIntSex(Integer intSex) {
		this.intSex = intSex;
	}
	public Integer getIntStatus() {
		return intStatus;
	}
	public void setIntStatus(Integer intStatus) {
		this.intStatus = intStatus;
	}
	public String getVchrPhotoURL() {
		return vchrPhotoURL;
	}
	public void setVchrPhotoURL(String vchrPhotoURL) {
		this.vchrPhotoURL = vchrPhotoURL;
	}
	public Date getDateCreateTime() {
		return dateCreateTime;
	}
	public void setDateCreateTime(Date dateCreateTime) {
		this.dateCreateTime = dateCreateTime;
	}
	public String getVchrAddress() {
		return vchrAddress;
	}
	public void setVchrAddress(String vchrAddress) {
		this.vchrAddress = vchrAddress;
	}
	public Long getIntDeptId() {
		return intDeptId;
	}
	public void setIntDeptId(Long intDeptId) {
		this.intDeptId = intDeptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Date getDateLastLoginTime() {
		return dateLastLoginTime;
	}
	public void setDateLastLoginTime(Date dateLastLoginTime) {
		this.dateLastLoginTime = dateLastLoginTime;
	}
	public BigDecimal getDecAccoundBalance() {
		return decAccoundBalance;
	}
	public void setDecAccoundBalance(BigDecimal decAccoundBalance) {
		this.decAccoundBalance = decAccoundBalance;
	}
	@Override
	public String toString() {
		return "YHDO [id=" + id + ", vchrAccount=" + vchrAccount + ", vchrPassword=" + vchrPassword + ", vchrNickname="
				+ vchrNickname + ", intSex=" + intSex + ", intStatus=" + intStatus + ", vchrPhotoURL=" + vchrPhotoURL
				+ ", dateCreateTime=" + dateCreateTime + ", dateLastLoginTime=" + dateLastLoginTime
				+ ", decAccoundBalance=" + decAccoundBalance + ", vchrAddress=" + vchrAddress + ", intDeptId="
				+ intDeptId + ", deptName=" + deptName + "]";
	}
	
}
