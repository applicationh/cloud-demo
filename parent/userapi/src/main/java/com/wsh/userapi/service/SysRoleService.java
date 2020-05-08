package com.wsh.userapi.service;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysRole;
import com.wsh.usercom.param.SysRoleParam;
import com.wsh.usercom.vo.SysRoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 后台角色表(SysRole)表服务接口
 *
 * @author wsh
 * 
 */
@FeignClient(name = "userserver")
@Service
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @GetMapping("/sysRole/queryById")
    SysRoleVo queryById(@RequestParam("id")Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @PostMapping("/sysRole/queryAll")
    PageInfo<SysRoleVo> queryAll(@RequestParam("pageNum")int pageNum, 
                                                 @RequestParam("pageSize")int pageSize,
                                                 @RequestBody SysRoleParam sysRoleParam);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysRole/insert")
    Boolean insert(@RequestBody SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @PutMapping("/sysRole/update")
    Boolean update(@RequestBody SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/sysRole/deleteById")
    Boolean deleteById(@RequestParam("id")Integer id);

}