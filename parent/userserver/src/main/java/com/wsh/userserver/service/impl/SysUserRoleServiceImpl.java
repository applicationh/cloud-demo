package com.wsh.userserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysUserRole;
import com.wsh.usercom.param.SysUserRoleParam;
import com.wsh.userserver.dao.SysUserRoleDao;
import com.wsh.userserver.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户—角色表(SysUserRole)表服务实现类
 *
 * @author wsh
 * 
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRole queryById(Integer id) {
        return sysUserRoleDao.queryById(id);
    }

    @Override
    public SysUserRole queryByRoleId(Integer roleId) {
        return sysUserRoleDao.queryByRoleId(roleId);
    }

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页码
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUserRole> queryAll(int pageNum, int pageSize,SysUserRoleParam sysUserRoleParam) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUserRole> sysUserRoleList=sysUserRoleDao.queryAll(sysUserRoleParam);
        PageInfo pageInfo = new PageInfo(sysUserRoleList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(SysUserRole sysUserRole) {
       return sysUserRoleDao.insert(sysUserRole) > 0;
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(SysUserRole sysUserRole) {
       return sysUserRoleDao.update(sysUserRole) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {

        return sysUserRoleDao.deleteById(id) > 0;
    }

    @Override
    public Boolean deleteByUserId(Integer id) {
        return sysUserRoleDao.deleteByUserId(id) > 0;

    }
}