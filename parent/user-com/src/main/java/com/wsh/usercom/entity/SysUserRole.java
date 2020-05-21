package com.wsh.usercom.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户—角色表(SysUserRole)实体类
 *
 * @author wsh
 * 
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -80824134354037520L;
    
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


}