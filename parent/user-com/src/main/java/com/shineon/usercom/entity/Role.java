package com.shineon.usercom.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-04-15 13:27:38
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -14956947994887004L;
    /**
    * 角色ID
    */
    private String id;
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
    * 是否系统出厂自带
    */
    private Integer system;
    /**
    * 逗号分隔的权限列表
    */
    private String privileges;
    
    private Date timecreated;
    
    private Date timemodified;
    
    private Integer flagdeleted;
    
    private Date timedeleted;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public Date getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Date timecreated) {
        this.timecreated = timecreated;
    }

    public Date getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(Date timemodified) {
        this.timemodified = timemodified;
    }

    public Integer getFlagdeleted() {
        return flagdeleted;
    }

    public void setFlagdeleted(Integer flagdeleted) {
        this.flagdeleted = flagdeleted;
    }

    public Date getTimedeleted() {
        return timedeleted;
    }

    public void setTimedeleted(Date timedeleted) {
        this.timedeleted = timedeleted;
    }

}