package com.wsh.userserver.controller;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.CopyUtil;
import com.wsh.usercom.entity.SysUser;
import com.wsh.usercom.entity.SysUserRole;
import com.wsh.usercom.param.SysUserParam;
import com.wsh.usercom.vo.SysRoleVo;
import com.wsh.usercom.vo.SysUserVo;
import com.wsh.userserver.service.SysUserRoleService;
import com.wsh.userserver.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统用户(SysUser)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public SysUser queryById(Integer id) {
        return sysUserService.queryById(id);
    }
    /**
     * 根据页码查询
     */
     @PostMapping("queryAll")
    public PageInfo<SysUser> queryAll(@RequestBody SysUserParam sysUserParam) {
        return sysUserService.queryAll(sysUserParam);
    }
    
     /**
     * 新增数据
     *
     */
    @PostMapping("insert")
    public Boolean insert(@RequestBody SysUser sysUser) {
        Boolean insert = sysUserService.insert(sysUser);
        insertRole(sysUser);
        return insert;
    }

    /**
     * 修改数据
     * @param sysUser 实例对象
     */
    @PostMapping("/update")
    public Boolean  update(@RequestBody SysUser sysUser){
        Boolean update = sysUserService.update(sysUser);
        insertRole(sysUser);
        return update;
    }

    private void insertRole(SysUser sysUser) {
        List<SysRoleVo> sysRoleVos = sysUser.getSysRoleVos();
        if (null!=sysRoleVos&&sysRoleVos.size() > 0) {
            sysUserRoleService.deleteByUserId(sysUser.getId());
            for (SysRoleVo sysRoleVo : sysRoleVos) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(sysRoleVo.getId());
                sysUserRole.setUserId(sysUser.getId());
                sysUserRole.setCreateTime(new Date());
                sysUserRoleService.insert(sysUserRole);
            }
        }
    }

    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Boolean deleteById(Integer id) {
        Boolean deleteById =sysUserService.deleteById(id);
        return deleteById;
    }

    @PostMapping("login")
    public SysUser login(@RequestParam("username") String username, @RequestParam("password") String password){
        SysUser  sysUser =sysUserService.login(username, password);
        return sysUser;
    }

    @PostMapping("getUserByName")
    SysUser getUserByName(@RequestParam("username") String username){
        SysUser  sysUser =sysUserService.getUserByName(username);
        return sysUser;
    }

}