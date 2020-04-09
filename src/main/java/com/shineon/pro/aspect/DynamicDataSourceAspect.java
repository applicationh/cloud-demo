package com.shineon.pro.aspect;

import com.shineon.pro.config.dynDataSource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: wsh
 */
@Aspect
@Order(-1)  // 该切面应当先于 @Transactional 执行
@Component
public class DynamicDataSourceAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 切换数据源
     */
    @Around("execution(@com.shineon.pro.aspect.DataSource * *(..))")
    public Object  aroundController(ProceedingJoinPoint pjp) throws Throwable {
        // 获取切入的 Method
        MethodSignature joinPointObject = (MethodSignature) pjp.getSignature();
        Method method = joinPointObject.getMethod();

        boolean flag = method.isAnnotationPresent(DataSource.class);
        if (flag) {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            setDataSource(dataSource,method);
        } else {
            // 如果方法上没有注解，则搜索类上是否有注解
            DataSource classDataSource = AnnotationUtils.findAnnotation(joinPointObject.getMethod().getDeclaringClass(), DataSource.class);
            if (classDataSource != null) {
                setDataSource(classDataSource,method);
            } else {
                DynamicDataSourceContextHolder.clearDataSourceKey();
                logger.info("没有注解使用默认的");
            }
        }
        Object proceed = pjp.proceed();
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        return proceed;
    }

    private void setDataSource(DataSource dataSource,Method method ) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(dataSource.value())) {
            logger.info("DataSource [{}] doesn't exist, use default DataSource [{}] " + dataSource.value());
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(dataSource.value());
            logger.info("Switch DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey() +
                    "] in Method [" + method.getName() + "]");
        }
    }

}
