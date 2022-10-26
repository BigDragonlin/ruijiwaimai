package com.furuitakeout.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final long id = Thread.currentThread().getId();
        log.info("MyHandlerInterceptor threadid：{}",id);
        //MyHandlerInterceptor threadid：502

        final Object loginFlag = request.getSession().getAttribute("loginFlag");
        final String requestURI = request.getRequestURI();
        log.info("正在访问的url网址是：{}",requestURI);
        if (loginFlag!=null){
            log.info("账号验证成功，可以进入,正在访问==》{}",request.getRequestURI().toString());
            return true;
        }
        log.info("账号验证失败，不可进入");
        response.sendRedirect("/backend/page/login/login.html");
        return false;
    }
}
