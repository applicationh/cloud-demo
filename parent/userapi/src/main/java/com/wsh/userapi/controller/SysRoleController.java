package com.wsh.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.wsh.userapi.service.SysUserRoleService;
import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.param.SysRoleParam;
import com.wsh.usercom.vo.SysRoleVo;
import com.wsh.userapi.utils.Result;
import com.wsh.userapi.service.SysRoleService;
import com.wsh.usercom.vo.SysUserRoleVo;
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
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @param menu 查询关联菜单
     * @return 单条数据
     */
    @GetMapping("queryById")
    public Result<SysRoleVo> queryById(@RequestParam("id") Integer id,
                                        @RequestParam(name = "menu",required = false,defaultValue = "false")Boolean menu) {
        SysRoleVo sysRoleVo= sysRoleService.queryById(id,menu);
         return Result.success(sysRoleVo);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public  Result<PageInfo<SysRoleVo>> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody(required = false) SysRoleParam sysRoleParam) {
        if(null==sysRoleParam){
            sysRoleParam=new SysRoleParam();
        }
        return Result.success(sysRoleService.queryAll(pageNum,pageSize,sysRoleParam));
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
        SysUserRoleVo sysUserRoleVo = sysUserRoleService.queryByRoleId(id);
        if (sysUserRoleVo == null) {
            Boolean deleteById = sysRoleService.deleteById(id);
            return Result.success(deleteById);
        }else{
            return Result.error("已有用户关联，不可删除");
        }
    }


}