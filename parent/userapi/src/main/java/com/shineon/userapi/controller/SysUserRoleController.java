package com.shineon.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUserRole;
import com.shineon.usercom.param.SysUserRoleParam;
import com.shineon.usercom.vo.SysUserRoleVo;
import com.shineon.userapi.utils.Result;
import com.shineon.userapi.service.SysUserRoleService;
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
    public Result<SysUserRoleVo> queryById(Integer id) {
        SysUserRoleVo sysUserRoleVo= sysUserRoleService.queryById(id);
         return Result.success(sysUserRoleVo);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public  Result<PageInfo<SysUserRoleVo>> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody(required = false) SysUserRoleParam sysUserRoleParam) {
        if(null==sysUserRoleParam){
            sysUserRoleParam=new SysUserRoleParam();
        }
        return Result.success(sysUserRoleService.queryAll(pageNum,pageSize,sysUserRoleParam));
    }
    
     /**
     * 新增数据
     * @param sysUserRole 实例对象
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysUserRole sysUserRole) {
        Boolean insert = sysUserRoleService.insert(sysUserRole);
        return Result.success(insert);
    }
    
     /**
     * 修改数据
     * @param sysUserRole 实例对象
     */
    @PutMapping("/update")
    public Result<Boolean>  update(@RequestBody SysUserRole sysUserRole){
        Boolean update = sysUserRoleService.update(sysUserRole);
        return Result.success(update);
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Result<Boolean> deleteById(Integer id) {
        Boolean deleteById = sysUserRoleService.deleteById(id);
        return Result.success(deleteById);
    }

}