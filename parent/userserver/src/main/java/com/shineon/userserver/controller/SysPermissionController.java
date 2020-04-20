package com.shineon.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysPermission;
import com.shineon.usercom.param.SysPermissionParam;
import com.shineon.userserver.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台权限表(SysPermission)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("sysPermission")
public class SysPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysPermissionService sysPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public SysPermission queryById(Integer id) {
        return sysPermissionService.queryById(id);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public PageInfo<SysPermission> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody SysPermissionParam sysPermissionParam) {
        return sysPermissionService.queryAll(pageNum,pageSize,sysPermissionParam);
    }
    
     /**
     * 新增数据
     *
     */
    @PostMapping("insert")
    public Boolean insert(@RequestBody SysPermission sysPermission) {
        Boolean insert = sysPermissionService.insert(sysPermission);
        return insert;
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Boolean deleteById(Integer id) {
        Boolean deleteById =sysPermissionService.deleteById(id);
        return deleteById;
    }

}