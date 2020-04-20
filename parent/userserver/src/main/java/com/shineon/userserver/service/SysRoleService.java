package com.shineon.userserver.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRole;
import com.shineon.usercom.param.SysRoleParam;

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
    SysRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    PageInfo<SysRole> queryAll(int pageNum, int pageSize,SysRoleParam sysRoleParam);

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