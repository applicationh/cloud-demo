package com.shineon.usercom.vo;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户—角色表(SysUserRole)vo
 *
 * @author wsh
 * 
 */
public class SysUserRoleVo implements Serializable {
    private static final long serialVersionUID = -95493881794334467L;
    
    private Integer id;
    /**
    * 角色ID
    */
    private Integer roleId;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 是否有效  1有效  2无效
    */
    private Integer deleteStatus;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}