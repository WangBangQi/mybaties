package com.zimo.mybaties.delayed;

/**
 * 任务
 */
public interface Task {

    //调用该方法，则会执行任务
    void executeTask();
}
