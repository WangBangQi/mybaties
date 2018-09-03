package com.zimo.mybaties.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 权限验证的注解
 * @author 子墨
 */
@Target(ElementType.METHOD) //目标是作用在方法上,
@Retention(RetentionPolicy.RUNTIME) //该注解起作用的时间是整个应用运行期间
public @interface Access {
    String permission();    //所需要的权限。
}
