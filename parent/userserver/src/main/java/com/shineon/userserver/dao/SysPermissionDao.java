package com.shineon.userserver.dao;

import com.shineon.usercom.entity.SysPermission;
import com.shineon.usercom.param.SysPermissionParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 后台权限表(SysPermission)表数据库访问层
 *
 * @author wsh
 * 
 */
@Mapper
public interface SysPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer id);

  
    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPermission 实例对象
     * @return 对象列表
     */
    List<SysPermission> queryAll(SysPermissionParam sysPermissionParam);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}