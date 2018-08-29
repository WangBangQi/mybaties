package com.zimo.mybaties.delayed.delayedtest;

import com.zimo.mybaties.delayed.Task;

public class AssistantTask implements Task {

    @Override
    public void executeTask() {
        System.out.println("assistant task run ");
        try {
            Thread.sleep(2*666);
        }catch (Exception e){

        }
    }
}
