package com.wsh.usercom.param;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台角色表(SysRole)参数类
 *
 * @author wsh
 * 
 */
public class SysRoleParam implements Serializable {
    private static final long serialVersionUID = 498067580072728092L;

    /**
    * ID
    */    
    private Integer id;
    
    private Integer page=1;
    
    private Integer limit=10;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    

}