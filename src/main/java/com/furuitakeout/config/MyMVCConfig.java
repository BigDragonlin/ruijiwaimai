package com.furuitakeout.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class MyMVCConfig implements WebMvcConfigurer {
    /**
     * 添加资源映射,没有资源映射找不到资源，可是为什么使用thymeleaf的时候不要呢？？？
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/backend/**")
              .addResourceLocations("classpath:/backend/");
      registry.addResourceHandler("/front/**")
              .addResourceLocations("classpath:/front/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("进入到interceptor中来");
        registry.addInterceptor(new MyHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/employee/login",
                        "/employee/logout",
                        "/backend/**",
                        "/front/**",
                        "/user/sendMsg",
                        "/user/login"
                );

    }
}
