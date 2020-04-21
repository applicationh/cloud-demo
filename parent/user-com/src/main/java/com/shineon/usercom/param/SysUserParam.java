package com.shineon.usercom.param;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户(SysUser)参数类
 *
 * @author wsh
 * 
 */
public class SysUserParam implements Serializable {
    private static final long serialVersionUID = -35556818017463337L;

    /**
    * ID
    */    
    private Integer id;
    
    private Integer page=1;
    
    private Integer limit=10;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public  Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }



}