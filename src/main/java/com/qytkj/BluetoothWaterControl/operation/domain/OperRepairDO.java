/**   
 * 功能描述：
 * @Package: com.qytkj.BluetoothWaterControl.operation.domain 
 * @author: hudaojin   
 * @date: 2018年5月14日 下午2:04:49 
 */
package com.qytkj.BluetoothWaterControl.operation.domain;

import java.io.Serializable;
import java.util.Date;


/** 
* @Description: 设备报修实体类(任务详情)
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年5月14日 下午2:04:49 
*/
public class OperRepairDO implements Serializable {

	private static final long serialVersionUID = 1L;

	//主键ID
	private Integer id;
	//任务状态
	private Integer taskStatus;
	//结束时间
	private Date finishTime;
	//报修人电话
	private Integer repairPhone;
	//维修人员
	private String maintainPerson;
	//问题选项
	private Integer problemOptions;
	//问题描述
	private String problemDescription;
	//创建时间	
	private Date createTime;
	//更新时间
	private Date lastEditTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Integer getRepairPhone() {
		return repairPhone;
	}
	public void setRepairPhone(Integer repairPhone) {
		this.repairPhone = repairPhone;
	}
	public String getMaintainPerson() {
		return maintainPerson;
	}
	public void setMaintainPerson(String maintainPerson) {
		this.maintainPerson = maintainPerson;
	}
	public Integer getProblemOptions() {
		return problemOptions;
	}
	public void setProblemOptions(Integer problemOptions) {
		this.problemOptions = problemOptions;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}	
}
