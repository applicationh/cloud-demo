package com.wsh.userserver.dao;

import com.wsh.usercom.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色-权限关联表(SysRoleMenu)表数据库访问层
 *
 * @author wsh
 * 
 */
@Mapper
public interface SysRoleMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoleMenu queryById(Integer id);
    boolean queryByPermissionId(Integer permissionId);

  
    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenuParam);

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(SysRoleMenu sysRoleMenu);

    /**
     * 修改数据
     *
     * @param sysRoleMenu 实例对象
     * @return 影响行数
     */
    int update(SysRoleMenu sysRoleMenu);


    int deleteByRoleId(@Param("roleId") Integer roleId);



}