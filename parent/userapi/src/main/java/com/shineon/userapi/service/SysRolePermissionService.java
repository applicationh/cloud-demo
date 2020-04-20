package com.shineon.userapi.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysRolePermission;
import com.shineon.usercom.param.SysRolePermissionParam;
import com.shineon.usercom.vo.SysRolePermissionVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 角色-权限关联表(SysRolePermission)表服务接口
 *
 * @author wsh
 * 
 */
@FeignClient(name = "userserver")
@Service
public interface SysRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @GetMapping("/sysRolePermission/queryById")
    SysRolePermissionVo queryById(@RequestParam("id")Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @PostMapping("/sysRolePermission/queryAll")
    PageInfo<SysRolePermissionVo> queryAll(@RequestParam("pageNum")int pageNum, 
                                                 @RequestParam("pageSize")int pageSize,
                                                 @RequestBody SysRolePermissionParam sysRolePermissionParam);

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysRolePermission/insert")
    Boolean insert(@RequestBody SysRolePermission sysRolePermission);

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @PutMapping("/sysRolePermission/update")
    Boolean update(@RequestBody SysRolePermission sysRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/sysRolePermission/deleteById")
    Boolean deleteById(@RequestParam("id")Integer id);

}