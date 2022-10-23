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
        final Object loginFlag = request.getSession().getAttribute("loginFlag");
        if (loginFlag!=null){
            log.info("账号验证成功，可以进入,正在访问==》{}",request.getRequestURI().toString());
            return true;
        }
        log.info("账号验证失败，不可进入");
        return false;
    }
}
