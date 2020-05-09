package com.wsh.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.param.SysRoleParam;
import com.wsh.userserver.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台角色表(SysRole)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public SysRole queryById(@RequestParam("id") Integer id,@RequestParam("menu")Boolean menu) {
        return sysRoleService.queryById(id,menu);
    }
    /**
     * 根据页码查询
     */
     @PostMapping("queryAll")
    public PageInfo<SysRole> queryAll(@RequestBody SysRoleParam sysRoleParam) {
        return sysRoleService.queryAll(sysRoleParam);
    }
    
     /**
     * 新增数据
     *
     */
    @PostMapping("insert")
    public Boolean insert(@RequestBody SysRole sysRole) {
        Boolean insert = sysRoleService.insert(sysRole);
        return insert;
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Boolean deleteById(Integer id) {
        Boolean deleteById =sysRoleService.deleteById(id);
        return deleteById;
    }

}