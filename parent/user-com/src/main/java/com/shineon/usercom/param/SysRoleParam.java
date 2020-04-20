package com.shineon.usercom.param;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台角色表(SysRole)参数类
 *
 * @author wsh
 * 
 */
public class SysRoleParam implements Serializable {
    private static final long serialVersionUID = 725263405869381151L;

    /**
    * ID
    */    
    private Integer id;
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}