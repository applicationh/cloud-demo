package com.shineon.userserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRolePermission;
import com.shineon.usercom.param.SysRolePermissionParam;
import com.shineon.userserver.dao.SysRolePermissionDao;
import com.shineon.userserver.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色-权限关联表(SysRolePermission)表服务实现类
 *
 * @author wsh
 * 
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRolePermission queryById(Integer id) {
        return sysRolePermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页码
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysRolePermission> queryAll(int pageNum, int pageSize,SysRolePermissionParam sysRolePermissionParam) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysRolePermission> sysRolePermissionList=sysRolePermissionDao.queryAll(sysRolePermissionParam);
        PageInfo pageInfo = new PageInfo(sysRolePermissionList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(SysRolePermission sysRolePermission) {
       return sysRolePermissionDao.insert(sysRolePermission) > 0;
    }

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(SysRolePermission sysRolePermission) {
       return sysRolePermissionDao.update(sysRolePermission) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        SysRolePermission sysRolePermission= new SysRolePermission();
        sysRolePermission.setId(id);
        sysRolePermission.setDeleteStatus(2);
        return sysRolePermissionDao.update(sysRolePermission) > 0;
    }
}