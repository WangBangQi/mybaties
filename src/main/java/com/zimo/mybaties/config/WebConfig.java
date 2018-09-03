package com.zimo.mybaties.config;

import com.zimo.mybaties.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有的请求，进入拦截器AuthenticationInterceptor中处理
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
    }


}
