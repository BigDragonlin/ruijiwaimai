package com.furuitakeout.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


/**
 * 这个是配合实体类自动填充的时候使用的
 * mybatis plus 3.3.0后用这种方法
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "create_time", LocalDateTime.now());
        this.fillStrategy(metaObject, "update_time", LocalDateTime.now());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "update_time", LocalDateTime.now());
    }
}

