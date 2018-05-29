/**  
* <p>Title: YWUserVO.java</p>  
* @author sj
* @date 2018年5月24日  
* @version 1.0  
*/ 
package com.qytkj.BluetoothWaterControl.backgroundManagement.vo;

import com.qytkj.BluetoothWaterControl.backgroundManagement.domain.YWDO;

/**
 * @author sj
 * @date 2018年5月24日 
 */
public class YWUserVO {
	/**
     * 更新的用户对象
     */
    private YWDO userDO = new YWDO();
    /**
     * 旧密码
     */
    private String pwdOld;
    /**
     * 新密码
     */
    private String pwdNew;

    public YWDO getUserDO() {
        return userDO;
    }

    public void setUserDO(YWDO userDO) {
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
