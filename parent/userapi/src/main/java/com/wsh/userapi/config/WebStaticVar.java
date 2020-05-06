package com.wsh.userapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.thymeleaf.expression.Maps;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wsh
 */
@Configuration
public class WebStaticVar {
    @Resource
    private Environment env;
    @Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if(viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("ctx", env.getProperty("ctx"));
            viewResolver.setStaticVariables(vars);
        }
    }

}
