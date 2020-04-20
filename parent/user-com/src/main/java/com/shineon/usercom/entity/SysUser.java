package com.shineon.usercom.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户(SysUser)实体类
 *
 * @author wsh
 * 
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 282869020964780700L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 显示名
    */
    private String displayName;
    /**
    * 有效
    */
    private Integer flagDeleted;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间（自动）
    */
    private Date updateTime;
    /**
    * 上一次登录的时间
    */
    private Date lastLoginTime;
    /**
    * 0  隐藏用户   1 普通用户  2 超级管理员
    */
    private Integer level;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public Integer getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Integer flagDeleted) {
        this.flagDeleted = flagDeleted;
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
    
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}