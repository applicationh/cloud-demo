package com.wsh.userapi.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import com.wsh.userapi.service.SysUserService;
import com.wsh.userapi.utils.Constants;
import com.wsh.usercom.entity.SysUser;
import com.wsh.usercom.vo.SysRoleVo;
import com.wsh.usercom.vo.SysUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: wsh
 */

public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("执行了授权");
//        Session session = SecurityUtils.getSubject().getSession();
//        //查询用户的权限
//        SysUser permission = (SysUser) session.getAttribute(Constants.SESSION_USER_PERMISSION);
//        logger.info("登录用户的值为:" + permission.getId());
        //为当前用户设置角色和权限
        //todo   db
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser principal = (SysUser) SecurityUtils.getSubject().getPrincipal();

        authorizationInfo.addStringPermission("user:add");
//        authorizationInfo.addStringPermissions( permission.getSysRoleVos().stream().map(SysRoleVo::getRoleCode).collect(Collectors.toList()));
        return authorizationInfo;
    }

    String slc = "shiro_login_count";
    String sll = "shiro_login_lock";

    /**
     * 获取身份验证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("执行了认证");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        SysUser login = sysUserService.getUserByName(username);
        //访问一次，计数一次
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.increment(slc + username, 1);
        //计数大于5时，设置用户被锁定一小时
        if(Integer.parseInt(opsForValue.get(slc+username))>5){
            opsForValue.set(sll+username, "LOCK");
            stringRedisTemplate.expire(sll+username, 1, TimeUnit.HOURS);
        }

        if ("LOCK".equals(opsForValue.get(sll+username))){
            throw new DisabledAccountException();
        }
        if (login == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(login,login.getPassword(),//ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                getName()
        );
        //session中不需要保存密码
        login.setPassword("");
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, login);
        return authenticationInfo;
    }
}
