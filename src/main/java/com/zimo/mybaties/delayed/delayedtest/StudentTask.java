package com.zimo.mybaties.delayed.delayedtest;

import com.zimo.mybaties.delayed.Task;

public class StudentTask implements Task{

    private Integer student;

    public StudentTask(Integer student) {
        this.student = student;
    }

    @Override
    public void executeTask() {
        System.out.println("学生任务执行"+student);
        try {
            Thread.sleep(10*1000);
        }catch (Exception e){

        }
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }
}
