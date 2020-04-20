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
    private static final long serialVersionUID = 920322538824893027L;

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