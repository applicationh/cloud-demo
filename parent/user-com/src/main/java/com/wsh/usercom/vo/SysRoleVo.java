package com.wsh.usercom.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台角色表(SysRole)vo
 *
 * @author wsh
 * 
 */
public class SysRoleVo implements Serializable {
    private static final long serialVersionUID = 251326152342093979L;
    /**
    * ID
    */        
    private Integer id;
    
    /**
    * 角色名
    */        
    private String roleName;
    
    /**
    * 角色代码
    */        
    private String roleCode;
    
    /**
    * 创建时间
    */        
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")    
    private Date createTime;
    
    /**
    * 更新时间
    */        
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")    
    private Date updateTime;
    
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
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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
    
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}