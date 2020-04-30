package com.wsh.usercom.param;

import java.io.Serializable;

/**
 * (Category)参数类
 *
 * @author wsh
 * 
 */
public class CategoryParam implements Serializable {
    private static final long serialVersionUID = -30878720396099139L;

    private String name;
    private String url;
    private String code;

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
}