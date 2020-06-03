package com.wsh.userserver.dao;

import com.wsh.usercom.entity.SysUser;
import com.wsh.usercom.param.SysUserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户(SysUser)表数据库访问层
 *
 * @author wsh
 * 
 */
@Mapper
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

  
    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserParam 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUserParam sysUserParam);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);


    SysUser login(@Param("username") String username, @Param("password") String password);

    SysUser getUserByName(@Param("username")String username);
}