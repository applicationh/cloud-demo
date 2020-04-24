package com.wsh.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysUserRole;
import com.wsh.usercom.param.SysUserRoleParam;
import com.wsh.userserver.service.SysUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户—角色表(SysUserRole)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("sysUserRole")
public class SysUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public SysUserRole queryById(Integer id) {
        return sysUserRoleService.queryById(id);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public PageInfo<SysUserRole> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody SysUserRoleParam sysUserRoleParam) {
        return sysUserRoleService.queryAll(pageNum,pageSize,sysUserRoleParam);
    }
    
     /**
     * 新增数据
     *
     */
    @PostMapping("insert")
    public Boolean insert(@RequestBody SysUserRole sysUserRole) {
        Boolean insert = sysUserRoleService.insert(sysUserRole);
        return insert;
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Boolean deleteById(Integer id) {
        Boolean deleteById =sysUserRoleService.deleteById(id);
        return deleteById;
    }

}