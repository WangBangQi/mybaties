package com.zimo.mybaties.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import java.sql.Statement;
import java.util.Properties;

/**
 * Sql执行时间记录拦截器
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })})
public class SqlCostInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(SqlCostInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            logger.info("sql 执行耗时为 ： {}ms",endTime -startTime);
        }
    }

    @Override
    public Object plugin(Object o) {
        //代理
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
