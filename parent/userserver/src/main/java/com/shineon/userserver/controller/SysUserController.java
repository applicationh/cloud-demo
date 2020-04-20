package com.shineon.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUser;
import com.shineon.usercom.param.SysUserParam;
import com.shineon.userserver.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统用户(SysUser)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public SysUser queryById(Integer id) {
        return sysUserService.queryById(id);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public PageInfo<SysUser> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody SysUserParam sysUserParam) {
        return sysUserService.queryAll(pageNum,pageSize,sysUserParam);
    }
    
     /**
     * 新增数据
     *
     */
    @PostMapping("insert")
    public Boolean insert(@RequestBody SysUser sysUser) {
        Boolean insert = sysUserService.insert(sysUser);
        return insert;
    }

}