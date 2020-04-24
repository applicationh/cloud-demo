package com.wsh.userapi.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: wsh
 */
@Component
@Aspect
public class SysLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //切点
    @Pointcut("@annotation(com.wsh.userapi.config.SysLog)")
    public void logPointcut() {}

    @Before("logPointcut()")
    public void saveLog(JoinPoint point){
        String s = Arrays.toString(point.getArgs());
        String methodName = point.getSignature().getName();
        HashMap<String,String> methodInfo = getMethodInfo(point);
        logger.info(String.format("方法%s 被访问，参数有%s，注解是%s和 %s"
                ,methodName,s,methodInfo.get("info"),methodInfo.get("type")));


    }


    /**
     * 获取自定义注解描述
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static HashMap<String,String> getMethodInfo(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        HashMap map = new HashMap();
        //获取类所有方法
        Method[] method = targetClass.getMethods();
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    SysLog sysLog = m.getAnnotation(SysLog.class);
                    if (sysLog != null) {
                        //可拓展
                        map.put("info", sysLog.info());
                        map.put("type", sysLog.type());
                    }
                    break;
                }
            }
        }
        return map;
    }
}
