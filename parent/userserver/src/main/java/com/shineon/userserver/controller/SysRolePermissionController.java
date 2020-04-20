package com.shineon.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRolePermission;
import com.shineon.usercom.param.SysRolePermissionParam;
import com.shineon.userserver.service.SysRolePermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色-权限关联表(SysRolePermission)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("sysRolePermission")
public class SysRolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysRolePermissionService sysRolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public SysRolePermission queryById(Integer id) {
        return sysRolePermissionService.queryById(id);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public PageInfo<SysRolePermission> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody SysRolePermissionParam sysRolePermissionParam) {
        return sysRolePermissionService.queryAll(pageNum,pageSize,sysRolePermissionParam);
    }
    
     /**
     * 新增数据
     *
     */
    @PostMapping("insert")
    public Boolean insert(@RequestBody SysRolePermission sysRolePermission) {
        Boolean insert = sysRolePermissionService.insert(sysRolePermission);
        return insert;
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Boolean deleteById(Integer id) {
        Boolean deleteById =sysRolePermissionService.deleteById(id);
        return deleteById;
    }

}