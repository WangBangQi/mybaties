package com.zimo.mybaties.delayed;

import com.zimo.mybaties.delayed.delayedtest.StudentTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDelayedServiceImpTest {
    @Autowired
    MyDelayedServiceImp myDelayedServiceImp;

    @Test
    public void put() throws Exception {
        myDelayedServiceImp.init();
        myDelayedServiceImp.put(new MyDelayedEvent(new StudentTask(1),System.currentTimeMillis()+30*1000,1));
    }

    @Test
    public void remove() throws Exception {
    }

}