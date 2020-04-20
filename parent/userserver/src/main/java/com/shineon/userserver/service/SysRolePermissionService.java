package com.shineon.userserver.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRolePermission;
import com.shineon.usercom.param.SysRolePermissionParam;

/**
 * 角色-权限关联表(SysRolePermission)表服务接口
 *
 * @author wsh
 * 
 */
public interface SysRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRolePermission queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    PageInfo<SysRolePermission> queryAll(int pageNum, int pageSize,SysRolePermissionParam sysRolePermissionParam);

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    Boolean insert(SysRolePermission sysRolePermission);

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    Boolean update(SysRolePermission sysRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

}