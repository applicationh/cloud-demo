package com.shineon.userapi.service;

import com.shineon.usercom.entity.Role;
import com.shineon.userapi.service.impl.RoleServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 15:35:01
 */
@FeignClient(name = "USERSERVER",fallback = RoleServiceImpl.class)
@Service
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @GetMapping("/role/selectOne")
    Role queryById(@RequestParam("id")String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @RequestMapping("/queryAllByLimit")
    List<Role> queryAllByLimit(@RequestParam("offset") int offset,@RequestParam("limit")  int limit);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @RequestMapping("/insert")
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @RequestMapping("/update")
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @RequestMapping("/deleteById")
    boolean deleteById(String id);

}