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
 * 运维APP的用户实体类
 * 对应数据表 yw_tbluser
 * @author  s j
 * @Date 2018年04月18日上午9:36:23
 */

public class YWDO implements Serializable{
    private static final long serialVersionUID = 1L;
    
	private Long intId;//用户ID（以及唯一身份识别）
	private String strLoginName;//登录名
	private String strPassword;//登录密码
	private String strStatus;//状态
	private String strRealName;//真实姓名
	private BigDecimal decAccountBalance;//账户余额
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateCreateTime;//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;//修改时间
	private String strAdress;//地址
	private Long intDept_id;//所属部门
	private String deptName;//部门名称
	
	public Long getIntId() {
		return intId;
	}
	public void setIntId(Long intId) {
		this.intId = intId;
	}
	public String getStrLoginName() {
		return strLoginName;
	}
	public void setStrLoginName(String strLoginName) {
		this.strLoginName = strLoginName;
	}
	public String getStrPassword() {
		return strPassword;
	}
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	public String getStrRealName() {
		return strRealName;
	}
	public void setStrRealName(String strRealName) {
		this.strRealName = strRealName;
	}
	public Date getDateCreateTime() {
		return dateCreateTime;
	}
	public void setDateCreateTime(Date dateCreateTime) {
		this.dateCreateTime = dateCreateTime;
	}
	public Long getIntDept_id() {
		return intDept_id;
	}
	public void setIntDept_id(Long intDept_id) {
		this.intDept_id = intDept_id;
	}
	public BigDecimal getDecAccountBalance() {
		return decAccountBalance;
	}
	public void setDecAccountBalance(BigDecimal decAccountBalance) {
		this.decAccountBalance = decAccountBalance;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getStrAdress() {
		return strAdress;
	}
	public void setStrAdress(String strAdress) {
		this.strAdress = strAdress;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "YWDO [intId=" + intId + ", strLoginName=" + strLoginName + ", strPassword=" + strPassword
				+ ", strStatus=" + strStatus + ", strRealName=" + strRealName + ", decAccountBalance="
				+ decAccountBalance + ", dateCreateTime=" + dateCreateTime + ", updateTime=" + updateTime
				+ ", strAdress=" + strAdress + ", intDept_id=" + intDept_id + ", deptName=" + deptName + "]";
	}

}
