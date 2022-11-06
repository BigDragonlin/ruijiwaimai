package com.furuitakeout.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.furuitakeout.common.MyThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.Set;


/**
 * 这个是配合实体类自动填充的时候使用的
 * mybatis plus 3.3.0后用这种方法
 */
@Configuration
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("in MyMetaObjectHandler insertFill .......MyThreadLocal:{}",MyThreadLocal.getCurrentId());
        //在插入和更新的时候清楚缓存
        final Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);

        this.fillStrategy(metaObject, "createTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "passWord", "123456");
        this.fillStrategy(metaObject,"updateUser", MyThreadLocal.getCurrentId());
        this.fillStrategy(metaObject,"createUser",MyThreadLocal.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //在插入和更新的时候清除缓存
        final Set keys1 = redisTemplate.keys("*");
        log.info("redis中的key：{}",keys1.toString());
        final Set keys = redisTemplate.keys("category*");
        redisTemplate.delete(keys);

        log.info("在插入自动填充");
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "update_time", LocalDateTime.now());
        this.fillStrategy(metaObject, "updateUser", MyThreadLocal.getCurrentId());

    }
}

