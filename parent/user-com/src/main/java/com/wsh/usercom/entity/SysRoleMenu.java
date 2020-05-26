package com.wsh.usercom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色-权限关联表(SysRoleMenu)实体类
 *
 * @author wsh
 * 
 */
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = -84120463949778282L;
            
    private Integer id;
    
    /**
    * 角色id
    */        
    private Integer roleId;
    
    /**
    * 权限id
    */        
    private Integer permissionId;
    
    /**
    * 创建时间
    */        
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")    
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
    
    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    


}