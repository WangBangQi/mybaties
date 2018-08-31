package com.zimo.mybaties.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {
    private static final TimeUnit MILLISECONDS_TIME_UNIT = TimeUnit.MILLISECONDS; //毫秒

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private ValueOperations<String,Object> valueOperations;
    @Autowired
    private ListOperations<String,Object> listOperations;
    @Autowired
    private SetOperations<String,Object> setOperations;
    @Autowired
    private HashOperations<String,String,Object> hashOperations;

    /**
     * 有有效期的缓存
     * @param key key
     * @param value 值
     * @param exTime 有效时间，单位秒
     */
    public void setStr(String key,Object value,long exTime){
        valueOperations.set(key,value,exTime,MILLISECONDS_TIME_UNIT);
    }

    public void setStr(String key,Object value){
        valueOperations.set(key,value);
    }

    public Object getStr(String key){
        return valueOperations.get(key);
    }

    public void del(String key){
        redisTemplate.delete(key);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }
}
