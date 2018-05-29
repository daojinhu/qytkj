/**  
* <p>Title: YWUserVO.java</p>  
* @author sj
* @date 2018年5月24日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.vo;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YHDO;

/**
 * @author sj
 * @date 2018年5月26日 
 */
public class YHUserVO {
	/**
     * 更新的用户对象
     */
    private YHDO userDO = new YHDO();
    /**
     * 旧密码
     */
    private String pwdOld;
    /**
     * 新密码
     */
    private String pwdNew;

    public YHDO getUserDO() {
        return userDO;
    }

    public void setUserDO(YHDO userDO) {
        this.userDO = userDO;
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }

}
