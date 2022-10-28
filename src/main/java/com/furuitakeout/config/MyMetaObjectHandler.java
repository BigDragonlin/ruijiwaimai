package com.furuitakeout.config;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.furuitakeout.common.MyThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


/**
 * 这个是配合实体类自动填充的时候使用的
 * mybatis plus 3.3.0后用这种方法
 */
@Configuration
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Autowired
    HttpSession httpSession;

    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime",LocalDateTime.now());

        metaObject.setValue("createUser", httpSession.getAttribute("loginID"));  //这里的id是不能直接获取的，所以这里先写死，后面教你怎么动态获取员工id
        metaObject.setValue("updateUser",httpSession.getAttribute("loginID"));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("进入到MyMetaObjectHandler updateFill");
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",httpSession.getAttribute("loginID"));
    }
}

