package com.wsh.userapi.service;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysUser;
import com.wsh.usercom.param.SysUserParam;
import com.wsh.usercom.vo.SysUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author wsh
 * 
 */
@FeignClient(name = "userserver")
@Service
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
     @GetMapping("/sysUser/queryById")
    SysUserVo queryById(@RequestParam("id")Integer id);

    /**
     * 查询多条数据
     */
    @PostMapping("/sysUser/queryAll")
    PageInfo<SysUserVo> queryAll(@RequestBody SysUserParam sysUserParam);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysUser/insert")
    Boolean insert(@RequestBody SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysUser/update")
    Boolean update(@RequestBody SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/sysUser/deleteById")
    Boolean deleteById(@RequestParam("id")Integer id);

}