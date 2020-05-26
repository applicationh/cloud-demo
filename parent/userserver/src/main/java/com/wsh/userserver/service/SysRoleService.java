package com.wsh.userserver.service;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.param.SysRoleParam;

/**
 * 后台角色表(SysRole)表服务接口
 *
 * @author wsh
 * 
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRole queryById(Integer id,Boolean menu);

    Boolean queryByPermissionId(Integer permissionId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    PageInfo<SysRole> queryAll(SysRoleParam sysRoleParam);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    Boolean insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    Boolean update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

}