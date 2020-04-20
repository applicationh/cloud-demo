package com.shineon.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUser;
import com.shineon.usercom.param.SysUserParam;
import com.shineon.usercom.vo.SysUserVo;
import com.shineon.userapi.utils.Result;
import com.shineon.userapi.service.SysUserService;
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
     @PostMapping("queryAll")
    public  Result<PageInfo<SysUserVo>> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody(required = false) SysUserParam sysUserParam) {
        if(null==sysUserParam){
            sysUserParam=new SysUserParam();
        }
        return Result.success(sysUserService.queryAll(pageNum,pageSize,sysUserParam));
    }
    
     /**
     * 新增数据
     * @param sysUser 实例对象
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysUser sysUser) {
        Boolean insert = sysUserService.insert(sysUser);
        return Result.success(insert);
    }
    
     /**
     * 修改数据
     * @param sysUser 实例对象
     */
    @PutMapping("/update")
    public Result<Boolean>  update(@RequestBody SysUser sysUser){
        Boolean update = sysUserService.update(sysUser);
        return Result.success(update);
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Result<Boolean> deleteById(Integer id) {
        Boolean deleteById = sysUserService.deleteById(id);
        return Result.success(deleteById);
    }

}