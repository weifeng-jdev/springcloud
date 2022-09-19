package com.amano.springcloud.config;

import com.amano.springcloud.util.RedisUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@Configuration
public class RedisConfiguration implements InitializingBean {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        RedisUtil.setRedisTemplate(redisTemplate);
    }
}