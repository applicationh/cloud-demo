package com.shineon.userserver.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUser;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author wsh
 * @since 2020-04-17 19:23:41
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    PageInfo<SysUser> queryAll(int pageNum, int pageSize,SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Boolean insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Boolean update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

}