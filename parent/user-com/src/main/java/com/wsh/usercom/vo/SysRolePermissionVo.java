package com.wsh.usercom.vo;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色-权限关联表(SysRolePermission)vo
 *
 * @author wsh
 * 
 */
public class SysRolePermissionVo implements Serializable {
    private static final long serialVersionUID = 520421844664479871L;
    
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