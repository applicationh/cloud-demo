package com.wsh.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wsh
 */
@Component
public class tokenFilter extends ZuulFilter {
    boolean b = false;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("这里是过滤开关，可以添加一些判断");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        System.out.println("验证token");
//        Object accessToken = request.getParameter("id");
//        if (accessToken == null) {
//
//            System.out.println("没有id");
//        }else{
//            System.out.println(" 有id");
//        }
//        if(accessToken == null) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("");
//        }

        return null;
    }
}
