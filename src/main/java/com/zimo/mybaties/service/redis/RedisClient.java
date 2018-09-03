package com.zimo.mybaties.service.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {
    private static final TimeUnit MILLISECONDS_TIME_UNIT = TimeUnit.MILLISECONDS; //毫秒
    private static final Logger logger  = LoggerFactory.getLogger(RedisClient.class);

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

    public<T> void hSet(String key,T t){
        hashOperations.putAll(key,classToMap(t));
    }
    public <T> T hGet(String key,Class<T> t){
        return mapToClass(hashOperations.entries(key),t);
    }


    public Object getStr(String key){
        return valueOperations.get(key);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }


    public <T> Map<String,Object> classToMap(T t){
        try {
            Map<String,Object> map = new HashMap<>();
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field :fields){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),t.getClass());
                Method readMethod = propertyDescriptor.getReadMethod();
                map.put(field.getName(),readMethod.invoke(t));
            }
            return map;
        }catch (Exception e){
            logger.error("ClassToMp error :{}",e.getLocalizedMessage());
            return null;
        }
    }

    public <T> T mapToClass(Map<String,Object> map,Class<T> t){
        if (map==null || map.size()==0) return null;
        try {
            T v = t.newInstance(); //要返回的对象
            Field[] fields = t.getDeclaredFields();
            for (Field field : fields){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),t);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                Object value = map.get(field.getName());
                writeMethod.invoke(v,value);
            }
            return v;
        }catch (Exception e){
            logger.error("MapToClass error :{}",e.getLocalizedMessage());
            return null;
        }
    }
}
