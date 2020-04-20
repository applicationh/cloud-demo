package com.shineon.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysPermission;
import com.shineon.usercom.param.SysPermissionParam;
import com.shineon.usercom.vo.SysPermissionVo;
import com.shineon.userapi.utils.Result;
import com.shineon.userapi.service.SysPermissionService;
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
    public Result<SysPermissionVo> queryById(Integer id) {
        SysPermissionVo sysPermissionVo= sysPermissionService.queryById(id);
         return Result.success(sysPermissionVo);
    }
    /**
     * 根据页码查询
     *
     * @param pageNum 从pageNum页开始
     * @param pageSize 每页pageSize条数据
     */
     @PostMapping("queryAll")
    public  Result<PageInfo<SysPermissionVo>> queryAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum, 
                                                        @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize,
                                                         @RequestBody(required = false) SysPermissionParam sysPermissionParam) {
        if(null==sysPermissionParam){
            sysPermissionParam=new SysPermissionParam();
        }
         PageInfo<SysPermissionVo> sysPermissionVoPageInfo = sysPermissionService.queryAll(pageNum, pageSize, sysPermissionParam);
         return Result.success(sysPermissionVoPageInfo);
    }
    
     /**
     * 新增数据
     * @param sysPermission 实例对象
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysPermission sysPermission) {
        Boolean insert = sysPermissionService.insert(sysPermission);
        return Result.success(insert);
    }
    
     /**
     * 修改数据
     * @param sysPermission 实例对象
     */
    @PutMapping("/update")
    public Result<Boolean>  update(@RequestBody SysPermission sysPermission){
        Boolean update = sysPermissionService.update(sysPermission);
        return Result.success(update);
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Result<Boolean> deleteById(@RequestParam("id") Integer id) {
        Boolean deleteById = sysPermissionService.deleteById(id);
        return Result.success(deleteById);
    }

}