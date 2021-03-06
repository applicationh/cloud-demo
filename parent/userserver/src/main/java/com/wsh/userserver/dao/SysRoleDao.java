package com.wsh.userserver.dao;

import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.param.SysRoleParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 后台角色表(SysRole)表数据库访问层
 *
 * @author wsh
 * 
 */
@Mapper
public interface SysRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRole queryById(Integer id);

  
    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleParam 实例对象
     * @return 对象列表
     */
    List<SysRole> queryAll(SysRoleParam sysRoleParam);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    SysRole queryByIdDetail(Integer id);
    SysRole getUserRoleName(Integer id);
}