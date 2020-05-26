package com.wsh.userserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.entity.SysRoleMenu;
import com.wsh.usercom.param.SysRoleParam;
import com.wsh.userserver.dao.SysRoleDao;
import com.wsh.userserver.dao.SysRoleMenuDao;
import com.wsh.userserver.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 后台角色表(SysRole)表服务实现类
 *
 * @author wsh
 * 
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;
    @Resource
    private SysRoleMenuDao sysRoleMenuDao;





    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Integer id,Boolean menu) {
        //查询关联菜单
        if (menu) {
            return sysRoleDao.queryByIdDetail(id);
        }
        return sysRoleDao.queryById(id);
    }

    @Override
    public Boolean queryByPermissionId(Integer permissionId) {
        return sysRoleMenuDao.queryByPermissionId(permissionId);
    }

    /**
     * 查询多条数据
     * @return 对象列表
     */
    @Override
    public PageInfo<SysRole> queryAll(SysRoleParam sysRoleParam) {
        PageHelper.startPage(sysRoleParam.getPage(),sysRoleParam.getLimit());
        List<SysRole> sysRoleList=sysRoleDao.queryAll(sysRoleParam);
        PageInfo pageInfo = new PageInfo(sysRoleList);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(SysRole sysRole) {
        sysRole.setDeleteStatus(1);
        return sysRoleDao.insert(sysRole) > 0;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(SysRole sysRole) {
        List<Integer> menuId = sysRole.getMenuId();
        if (menuId != null) {
            Date date = new Date();
            sysRoleMenuDao.deleteByRoleId(sysRole.getId());
            menuId.forEach(integer ->{
                        SysRoleMenu sys = new SysRoleMenu();
                        sys.setCreateTime(date);
                        sys.setRoleId(sysRole.getId());
                        sys.setPermissionId(integer);
                        sysRoleMenuDao.insert(sys);
                    }
            );
        }else{
            sysRoleDao.update(sysRole);
        }

        return true;

    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer id) {
        SysRole sysRole= new SysRole();
        sysRole.setId(id);
        sysRole.setDeleteStatus(2);
        sysRoleMenuDao.deleteByRoleId(id);
        return sysRoleDao.update(sysRole) > 0;
    }
}