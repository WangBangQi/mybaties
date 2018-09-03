package com.zimo.mybaties.annoation;

import java.lang.annotation.*;

/**
 * @description token注解，标注该注解则说明需要token检验,验证token的有效性。
 * @author 子墨
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Token {
}
