package com.shineon.usercom.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户(SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-17 11:41:59
 */
public class SysUserVo implements Serializable {
    private static final long serialVersionUID = 933734264871241526L;
    /**
    * ID
    */
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}