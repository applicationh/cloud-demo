package com.wsh.usercom.param;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户—角色表(SysUserRole)参数类
 *
 * @author wsh
 * 
 */
public class SysUserRoleParam implements Serializable {
    private static final long serialVersionUID = 480543114183378460L;

        
    private Integer id;
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}