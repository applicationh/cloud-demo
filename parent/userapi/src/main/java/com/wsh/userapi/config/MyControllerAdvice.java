package com.wsh.userapi.config;

import com.alibaba.fastjson.JSONObject;
import com.wsh.userapi.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 统一异常处理
 * @Author: wsh
 */
@RestControllerAdvice
public class MyControllerAdvice {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 全局异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        StringBuffer requestURL = request.getRequestURL();
        String remoteAddr = request.getRemoteAddr();
        int serverPort = request.getServerPort();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        JSONObject paramJson = new JSONObject();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                paramJson.put(en, value);
                //如果字段的值为空，判断若值为空，则删除这个字段>
                if (null == paramJson.get(en) || "".equals(paramJson.get(en))) {
                    paramJson.remove(en);
                }
            }
        }
        //可入库
        logger.error(String.format("报错:访问ip：%s，端口：%s，路径：%S，全路径：%s，方式：%s，参数：%s",
                remoteAddr,serverPort,requestURI,requestURL,method,paramJson.toJSONString()));
        return Result.error(ex.getMessage());
    }
}
