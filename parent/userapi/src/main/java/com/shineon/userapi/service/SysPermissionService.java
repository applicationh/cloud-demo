package com.shineon.userapi.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysPermission;
import com.shineon.usercom.param.SysPermissionParam;
import com.shineon.usercom.vo.SysPermissionVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 后台权限表(SysPermission)表服务接口
 *
 * @author wsh
 * 
 */
@FeignClient(name = "userserver")
@Service
public interface SysPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @GetMapping("/sysPermission/queryById")
    SysPermissionVo queryById(@RequestParam("id")Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @PostMapping("/sysPermission/queryAll")
    PageInfo<SysPermissionVo> queryAll(@RequestParam("pageNum")int pageNum, 
                                                 @RequestParam("pageSize")int pageSize,
                                                 @RequestBody SysPermissionParam sysPermissionParam);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysPermission/insert")
    Boolean insert(@RequestBody SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @PutMapping("/sysPermission/update")
    Boolean update(@RequestBody SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/sysPermission/deleteById")
    Boolean deleteById(@RequestParam("id")Integer id);

}