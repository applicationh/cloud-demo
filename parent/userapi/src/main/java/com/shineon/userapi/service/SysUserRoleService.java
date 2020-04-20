package com.shineon.userapi.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUserRole;
import com.shineon.usercom.param.SysUserRoleParam;
import com.shineon.usercom.vo.SysUserRoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 用户—角色表(SysUserRole)表服务接口
 *
 * @author wsh
 * 
 */
@FeignClient(name = "userserver")
@Service
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @GetMapping("/sysUserRole/queryById")
    SysUserRoleVo queryById(@RequestParam("id")Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @PostMapping("/sysUserRole/queryAll")
    PageInfo<SysUserRoleVo> queryAll(@RequestParam("pageNum")int pageNum, 
                                                 @RequestParam("pageSize")int pageSize,
                                                 @RequestBody SysUserRoleParam sysUserRoleParam);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysUserRole/insert")
    Boolean insert(@RequestBody SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @PutMapping("/sysUserRole/update")
    Boolean update(@RequestBody SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/sysUserRole/deleteById")
    Boolean deleteById(@RequestParam("id")Integer id);

}