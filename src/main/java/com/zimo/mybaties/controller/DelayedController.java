package com.zimo.mybaties.controller;

import com.zimo.mybaties.delayed.MyDelayedEvent;
import com.zimo.mybaties.delayed.MyDelayedService;
import com.zimo.mybaties.delayed.delayedtest.AssistantTask;
import com.zimo.mybaties.delayed.delayedtest.StudentTask;
import com.zimo.mybaties.util.Result;
import com.zimo.mybaties.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DelayedController {

    @Autowired
    private MyDelayedService myDelayedService;

    @RequestMapping("/put")
    public Result put(@RequestParam("delay")Integer delay,Integer n) {
        long nowTime = System.currentTimeMillis();
        for (int j=0;j<n;j++) {
            for (int i = 0; i < 10; i++) {
                MyDelayedEvent delayed = new MyDelayedEvent(new StudentTask(i*(j+1)), nowTime + (delay+j) * 1000, i*(j+1));
                MyDelayedEvent delayed_assistant = new MyDelayedEvent(new AssistantTask(), nowTime + (delay+j+1) * 1000 + 1000, i*(j+1));
                myDelayedService.put(delayed_assistant);
                myDelayedService.put(delayed);

                if (i == 3 || i == 9) {
                    MyDelayedEvent delayed_t = new MyDelayedEvent(new StudentTask(i*(j+1)), nowTime + (delay+j) * 1000, i*(j+1));
                    myDelayedService.remove(delayed_t);
                }
            }
        }
        return ResultUtil.success();
    }
}
