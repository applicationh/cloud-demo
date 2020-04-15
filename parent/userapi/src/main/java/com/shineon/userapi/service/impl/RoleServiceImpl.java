package com.shineon.userapi.service.impl;

import com.shineon.usercom.entity.Role;
import com.shineon.userapi.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 15:35:03
 */
public class RoleServiceImpl implements RoleService {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(String id) {

        System.out.println("调用了本地的");
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Role> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {

        return null;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return false;
    }
}