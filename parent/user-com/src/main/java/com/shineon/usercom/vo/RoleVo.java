package com.shineon.usercom.vo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Role)vo
 *
 * @author makejava
 * @since 2020-04-15 17:35:56
 */
public class RoleVo implements Serializable {
    private static final long serialVersionUID = -92540370051336275L;

    /**
    * 角色名称
    */
    private String title;
    /**
    * 角色描述
    */
    private String descr;
    /**
    * 是否超级管理员
    */
    private Integer admin;

    /**
    * 逗号分隔的权限列表
    */
    private String privileges;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
}