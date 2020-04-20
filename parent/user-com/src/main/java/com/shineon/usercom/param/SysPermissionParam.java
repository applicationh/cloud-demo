package com.shineon.usercom.param;

import java.io.Serializable;

/**
 * 后台权限表(SysPermission)参数类
 *
 * @author wsh
 * 
 */
public class SysPermissionParam implements Serializable {
    private static final long serialVersionUID = -88780471770404318L;

    /**
    * 自定id,主要供前端展示权限列表分类排序使用.
    */    
    private Integer id;
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}