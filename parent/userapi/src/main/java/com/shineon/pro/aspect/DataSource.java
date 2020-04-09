package com.shineon.pro.aspect;

import java.lang.annotation.*;

/**
 * @Author: wsh
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value();
}
