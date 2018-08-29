package com.zimo.mybaties.listents;

import com.zimo.mybaties.delayed.MyDelayedServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyBatiesApplicationListen implements ServletContextListener {
    @Autowired
    private MyDelayedServiceImp myDelayedServiceImp;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        myDelayedServiceImp.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
