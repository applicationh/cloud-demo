package com.wsh.usercom.entity;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author wsh
 * 
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -13307763680596971L;
    /**
    * id
    */
    private Integer id;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 菜单路径
    */
    private String url;
    /**
    * 权限表示
    */
    private String code;
    /**
    * 顺序
    */
    private Integer sort;
    /**
    * 类型1菜单  2按钮
    */
    private Integer type;

    private Integer pid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}