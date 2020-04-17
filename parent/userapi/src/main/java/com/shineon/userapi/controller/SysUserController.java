package com.shineon.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUser;
import com.shineon.usercom.vo.SysUserVo;
import com.shineon.userapi.utils.Result;
import com.shineon.userapi.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统用户(SysUser)表控制层
 *
 * @author wsh
 * @since 2020-04-17 18:03:18
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
    public Result<SysUserVo> queryById(Integer id) {
        SysUserVo sysUserVo= sysUserService.queryById(id);
         return Result.success(sysUserVo);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @GetMapping("queryAll")
    public  Result<PageInfo<SysUserVo>> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody SysUser sysUser) {
        return Result.success(sysUserService.queryAll(pageNum,pageSize,sysUser));
    }
    
     /**
     * 新增数据
     *
     */
    @GetMapping("queryAll")
    public Result<Boolean> insert(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
        return Result.success();
    }

}