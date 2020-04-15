package com.shineon.userapi.controller;

import com.shineon.usercom.CopyUtil;
import com.shineon.usercom.entity.Role;
import com.shineon.userapi.service.RoleService;
import com.shineon.usercom.vo.RoleVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-04-09 15:35:04
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RoleVo selectOne(String id) {
        Role role = this.roleService.queryById(id);
        RoleVo roleVo = new RoleVo();
        CopyUtil.copyPojo(role, roleVo);
        return roleVo;
    }

}