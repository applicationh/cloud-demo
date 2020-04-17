package com.shineon.userapi.service;

import com.github.pagehelper.PageInfo;
import com.shineon.usercom.entity.SysUser;
import com.shineon.usercom.vo.SysUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author wsh
 * @since 2020-04-17 17:30:31
 */
@FeignClient(name = "")// todo 需要填
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
     *
     * @param pageNum 查询页数
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @GetMapping("/sysUser/queryAllByLimit")
    PageInfo<SysUserVo> queryAll(@RequestParam("pageNum")int pageNum, 
                                                 @RequestParam("pageSize")int pageSize,
                                                 @RequestBody SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("/sysUser/insert")
    SysUser insert(@RequestBody SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PutMapping("/sysUser/update")
    SysUser update(@RequestBody SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/sysUser/deleteById")
    boolean deleteById(@RequestParam("id")Integer id);

}