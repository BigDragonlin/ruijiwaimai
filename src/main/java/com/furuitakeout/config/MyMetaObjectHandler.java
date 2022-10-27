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
        log.info("in MyMetaObjectHandler insertFill .......MyThreadLocal:{}",MyThreadLocal.getCurrentId());

        this.fillStrategy(metaObject, "createTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "passWord", "123456");
        this.fillStrategy(metaObject,"updateUser", MyThreadLocal.getCurrentId());
        this.fillStrategy(metaObject,"createUser",MyThreadLocal.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("in MyMetaObjectHandler updateFill .......,MyThreadLocal.getCurrentId()++{}",MyThreadLocal.getCurrentId());
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "update_time", LocalDateTime.now());
        this.fillStrategy(metaObject, "updateUser", MyThreadLocal.getCurrentId());

    }
}

