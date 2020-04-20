package com.shineon.userserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysPermission;
import com.shineon.usercom.param.SysPermissionParam;
import com.shineon.userserver.dao.SysPermissionDao;
import com.shineon.userserver.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台权限表(SysPermission)表服务实现类
 *
 * @author wsh
 * 
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermission queryById(Integer id) {
        return sysPermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页码
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysPermission> queryAll(int pageNum, int pageSize,SysPermissionParam sysPermissionParam) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysPermission> sysPermissionList=sysPermissionDao.queryAll(sysPermissionParam);
        PageInfo pageInfo = new PageInfo(sysPermissionList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(SysPermission sysPermission) {
       return sysPermissionDao.insert(sysPermission) > 0;
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(SysPermission sysPermission) {
       return sysPermissionDao.update(sysPermission) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        SysPermission sysPermission= new SysPermission();
        sysPermission.setId(id);
        sysPermission.setDeleteStatus(2);
        return sysPermissionDao.update(sysPermission) > 0;
    }
}