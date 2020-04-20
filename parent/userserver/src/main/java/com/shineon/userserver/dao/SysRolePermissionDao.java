package com.shineon.userserver.dao;

import com.shineon.usercom.entity.SysRolePermission;
import com.shineon.usercom.param.SysRolePermissionParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色-权限关联表(SysRolePermission)表数据库访问层
 *
 * @author wsh
 * 
 */
@Mapper
public interface SysRolePermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRolePermission queryById(Integer id);

  
    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRolePermission 实例对象
     * @return 对象列表
     */
    List<SysRolePermission> queryAll(SysRolePermissionParam sysRolePermissionParam);

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 影响行数
     */
    int insert(SysRolePermission sysRolePermission);

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 影响行数
     */
    int update(SysRolePermission sysRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}