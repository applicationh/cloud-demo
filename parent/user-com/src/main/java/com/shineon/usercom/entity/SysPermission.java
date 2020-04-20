package com.shineon.usercom.entity;

import java.io.Serializable;

/**
 * 后台权限表(SysPermission)实体类
 *
 * @author wsh
 * 
 */
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -30150998317332078L;
    /**
    * 自定id,主要供前端展示权限列表分类排序使用.
    */
    private Integer id;
    /**
    * 归属菜单,前端判断并展示菜单使用,
    */
    private String menuCode;
    /**
    * 菜单的中文释义
    */
    private String menuName;
    /**
    * 权限的代码
    */
    private String permissionCode;
    /**
    * 本权限的中文释义
    */
    private String permissionName;
    /**
    * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
    */
    private Integer requiredPermission;
    /**
    * 是否有效  1有效  2无效
    */
    private Integer deleteStatus;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
    
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    
    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
    
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
    
    public Integer getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(Integer requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
    
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}