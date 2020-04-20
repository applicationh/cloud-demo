package com.shineon.userserver.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysPermission;
import com.shineon.usercom.param.SysPermissionParam;

/**
 * 后台权限表(SysPermission)表服务接口
 *
 * @author wsh
 * 
 */
public interface SysPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    PageInfo<SysPermission> queryAll(int pageNum, int pageSize,SysPermissionParam sysPermissionParam);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    Boolean insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    Boolean update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

}