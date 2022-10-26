package com.furuitakeout.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.furuitakeout.common.MyThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


/**
 * 这个是配合实体类自动填充的时候使用的
 * mybatis plus 3.3.0后用这种方法
 */
@Configuration
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("in MyMetaObjectHandler insertFill .......");
        this.fillStrategy(metaObject, "create_time", LocalDateTime.now());
        this.fillStrategy(metaObject, "update_time", LocalDateTime.now());
        this.fillStrategy(metaObject, "password", "123456");
        this.fillStrategy(metaObject,"update_user", MyThreadLocal.getCurrentId());
        this.fillStrategy(metaObject,"create_user",MyThreadLocal.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("in MyMetaObjectHandler updateFill .......,MyThreadLocal.getCurrentId()++{}",MyThreadLocal.getCurrentId());
        this.fillStrategy(metaObject, "update_time", LocalDateTime.now());
        this.fillStrategy(metaObject, "update_user", MyThreadLocal.getCurrentId());
    }
}

