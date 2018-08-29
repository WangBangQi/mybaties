package com.zimo.mybaties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.zimo.mybaties.dao")
@ServletComponentScan	//添加该注解使其能扫描到我们的监听

public class MybatiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatiesApplication.class, args);
	}
}
