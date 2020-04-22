package com.shineon.userserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUser;
import com.shineon.usercom.param.SysUserParam;
import com.shineon.userserver.dao.SysUserDao;
import com.shineon.userserver.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统用户(SysUser)表服务实现类
 *
 * @author wsh
 * 
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUser> queryAll(SysUserParam sysUserParam) {
        PageHelper.startPage(sysUserParam.getPage(),sysUserParam.getLimit());
        List<SysUser> sysUserList=sysUserDao.queryAll(sysUserParam);
        PageInfo pageInfo = new PageInfo(sysUserList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        sysUser.setDeleteStatus(1);
        return sysUserDao.insert(sysUser) > 0;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(SysUser sysUser) {
       return sysUserDao.update(sysUser) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        SysUser sysUser= new SysUser();
        sysUser.setId(id);
        sysUser.setDeleteStatus(2);
        return sysUserDao.update(sysUser) > 0;
    }
}