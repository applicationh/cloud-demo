package com.shineon.usercom.vo;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台角色表(SysRole)vo
 *
 * @author wsh
 * 
 */
public class SysRoleVo implements Serializable {
    private static final long serialVersionUID = -89036679722032299L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 角色名
    */
    private String roleName;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
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