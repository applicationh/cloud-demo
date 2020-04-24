package com.wsh.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.wsh.userapi.service.SysRoleService;
import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.param.SysRoleParam;
import com.wsh.usercom.vo.SysRoleVo;
import com.wsh.userapi.utils.Result;
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
    public Result<SysRoleVo> queryById(Integer id) {
        SysRoleVo sysRoleVo= sysRoleService.queryById(id);
         return Result.success(sysRoleVo);
    }
    /**
     * 根据页码查询
     */
     @PostMapping("queryAll")
    public  Result<PageInfo<SysRoleVo>> queryAll(@RequestBody(required = false) SysRoleParam sysRoleParam) {
        return Result.success(sysRoleService.queryAll(sysRoleParam));
    }
    
     /**
     * 新增数据
     * @param sysRole 实例对象
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysRole sysRole) {
        Boolean insert = sysRoleService.insert(sysRole);
        return Result.success(insert);
    }
    
     /**
     * 修改数据
     * @param sysRole 实例对象
     */
    @PutMapping("/update")
    public Result<Boolean>  update(@RequestBody SysRole sysRole){
        Boolean update = sysRoleService.update(sysRole);
        return Result.success(update);
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Result<Boolean> deleteById(Integer id) {
        Boolean deleteById = sysRoleService.deleteById(id);
        return Result.success(deleteById);
    }

}