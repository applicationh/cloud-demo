package com.wsh.userapi.controller;

import com.github.pagehelper.PageInfo;
import com.wsh.usercom.entity.SysUser;
import com.wsh.usercom.param.SysUserParam;
import com.wsh.usercom.vo.SysUserVo;
import com.wsh.userapi.utils.Result;
import com.wsh.userapi.service.SysUserService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.UnknownUserException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public Result<SysUserVo> queryById(Integer id) {
        SysUserVo sysUserVo= sysUserService.queryById(id);
         return Result.success(sysUserVo);
    }
    /**
     * 根据页码查询
     */
     @PostMapping("queryAll")
    public  Result<PageInfo<SysUserVo>> queryAll(@RequestBody(required = false) SysUserParam sysUserParam) {
        return Result.success(sysUserService.queryAll(sysUserParam));
    }
    
     /**
     * 新增数据
     * @param sysUser 实例对象
     */
    @PostMapping("insert")
    public Result<Boolean> insert(@RequestBody SysUser sysUser) {
        Boolean insert = sysUserService.insert(sysUser);
        return Result.success(insert);
    }
    
     /**
     * 修改数据
     * @param sysUser 实例对象
     */
    @PutMapping("/update")
    public Result<Boolean>  update(@RequestBody SysUser sysUser){
        Boolean update = sysUserService.update(sysUser);
        return Result.success(update);
    }
    
    
    /**
     * 删除数据
     */
    @DeleteMapping("/deleteById")
    public Result<Boolean> deleteById(Integer id) {
        Boolean deleteById = sysUserService.deleteById(id);
        return Result.success(deleteById);
    }

    @PostMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
            return Result.success();
        } catch (UnknownAccountException e) {
            return Result.error("用户不存在");
        } catch (IncorrectCredentialsException e) {
            return Result.error("密码不正确");
        } catch (DisabledAccountException e) {
            return Result.error("由于密码输入错误次数大于5次，帐号已经禁止登录！请一小时后重试");
        }
//        SysUser sysUser = sysUserService.login(username,password);
//        if (sysUser != null) {
//            return Result.success();
//        }else{
//            return Result.error("用户不存在");
//        }
    }

}