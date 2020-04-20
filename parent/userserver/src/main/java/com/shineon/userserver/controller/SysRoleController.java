package com.shineon.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRole;
import com.shineon.usercom.param.SysRoleParam;
import com.shineon.userserver.service.SysRoleService;
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
    public SysRole queryById(Integer id) {
        return sysRoleService.queryById(id);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public PageInfo<SysRole> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody SysRoleParam sysRoleParam) {
        return sysRoleService.queryAll(pageNum,pageSize,sysRoleParam);
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