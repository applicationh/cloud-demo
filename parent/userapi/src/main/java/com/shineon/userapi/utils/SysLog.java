package com.shineon.userapi.utils;

import java.lang.annotation.*;

/**
 * @Author: wsh
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String info() default "";
    String type() default "0"; //1234 增删改查
}
