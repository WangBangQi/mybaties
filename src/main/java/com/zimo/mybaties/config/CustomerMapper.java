package com.zimo.mybaties.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;

/**
 * 配置ObjectMapper类，使得其在转换延迟加载的对象是不会报错。
 */
@Configuration
public class CustomerMapper extends ObjectMapper {
    public CustomerMapper() {
//        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
    }
}
