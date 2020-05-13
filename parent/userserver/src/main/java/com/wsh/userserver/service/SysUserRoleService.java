package com.wsh.userserver.service;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysUserRole;
import com.wsh.usercom.param.SysUserRoleParam;

/**
 * 用户—角色表(SysUserRole)表服务接口
 *
 * @author wsh
 * 
 */
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRole queryById(Integer id);

    SysUserRole queryByRoleId(Integer roleId);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    PageInfo<SysUserRole> queryAll(int pageNum, int pageSize,SysUserRoleParam sysUserRoleParam);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    Boolean insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    Boolean update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

}