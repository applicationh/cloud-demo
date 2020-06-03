package com.wsh.userapi.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: wsh
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new LinkedHashMap<>();
        //anon:无需认证即可访问 authc:需要认证才可访问 user:点击“记住我”功能可访问 perms:拥有权限才可以访问 role:拥有某个角色权限才能访问
//        map.put("/logout", "logout");

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //不过滤
        map.put("/img/**","anon");
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/fonts/**","anon");
        map.put("/dtree/** ","anon");
        map.put("/images/face/**","anon");
        map.put("/lay/modules/**","anon");
        map.put("/com.js","anon");
        map.put("/layui.all.js","anon");
        map.put("/layui.js","anon");
        map.put("/favicon.ico","anon");


//        map.put("/user/sys/*.*", "perms[user:add]");
//        map.put("/sysUser/**", "perms[user:add]");

        map.put("/sys/userList.html", "perms[user:add]");
        map.put("/index", "perms[user:add]");

        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }



    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
