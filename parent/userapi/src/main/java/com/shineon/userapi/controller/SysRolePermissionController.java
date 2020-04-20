package com.shineon.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRolePermission;
import com.shineon.usercom.param.SysRolePermissionParam;
import com.shineon.usercom.vo.SysRolePermissionVo;
import com.shineon.userapi.utils.Result;
import com.shineon.userapi.service.SysRolePermissionService;
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
    public Result<SysRolePermissionVo> queryById(Integer id) {
        SysRolePermissionVo sysRolePermissionVo= sysRolePermissionService.queryById(id);
         return Result.success(sysRolePermissionVo);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public  Result<PageInfo<SysRolePermissionVo>> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody(required = false) SysRolePermissionParam sysRolePermissionParam) {
        if(null==sysRolePermissionParam){
            sysRolePermissionParam=new SysRolePermissionParam();
        }
        return Result.success(sysRolePermissionService.queryAll(pageNum,pageSize,sysRolePermissionParam));
    }
    
     /**
     * 新增数据
     * @param sysRolePermission 实例对象
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysRolePermission sysRolePermission) {
        Boolean insert = sysRolePermissionService.insert(sysRolePermission);
        return Result.success(insert);
    }
    
     /**
     * 修改数据
     * @param sysRolePermission 实例对象
     */
    @PutMapping("/update")
    public Result<Boolean>  update(@RequestBody SysRolePermission sysRolePermission){
        Boolean update = sysRolePermissionService.update(sysRolePermission);
        return Result.success(update);
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Result<Boolean> deleteById(Integer id) {
        Boolean deleteById = sysRolePermissionService.deleteById(id);
        return Result.success(deleteById);
    }

}