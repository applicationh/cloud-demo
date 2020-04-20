package com.shineon.usercom.vo;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户(SysUser)vo
 *
 * @author wsh
 * 
 */
public class SysUserVo implements Serializable {
    private static final long serialVersionUID = 430464234781489883L;
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
    
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}