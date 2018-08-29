package com.zimo.mybaties.delayed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class MyDelayedServiceImp implements MyDelayedService{

    private static final Logger logger = LoggerFactory.getLogger(MyDelayedServiceImp.class);
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DelayQueue<MyDelayedEvent> queue = new DelayQueue<>();
    private Executor executor = Executors.newFixedThreadPool(30);//线程池,保证同一时刻执行的任务能执行s
    private Thread damon;//守护线程

    @Override
    public void init(){
        logger.info("初始化学生守护线程");
        damon = new Thread(() -> execute()); //新建一个线程，执行execute方法
        damon.setDaemon(true);  //设置为守护线程
        damon.setName("student queue thread");  //线程名称
        damon.start();  //启动线程
    }

    @Override
    public void put(MyDelayedEvent delayed){
        logger.info("插入任务:任务uniqueKey:{},任务开始时间是：{}",delayed.getUniqueKey(),TIME_FORMAT.format(delayed.getEndTime()));
        queue.put(delayed);
    }

    @Override
    public boolean remove(MyDelayedEvent delayed){
        logger.info("移除任务:任务uniqueKey:{},该任务的开始时间是：{}",delayed.getUniqueKey(),TIME_FORMAT.format(delayed.getEndTime()));
        return queue.remove(delayed);
    }

    private void execute(){
        while (true){
            //该线程要执行的内容
            try {
                MyDelayedEvent delayed = queue.take();
                if (delayed!=null){
                    logger.info("执行任务,任务执行时当前时间是 {}",TIME_FORMAT.format(delayed.getEndTime()));
                    executor.execute(new Runnable() {
                        //将执行的任务放入线程池，同一个时刻可能有多个任务要执行
                        @Override
                        public void run() {
                            delayed.getTask().executeTask();//执行任务
                        }
                    });

                }
            }catch (InterruptedException e){
                logger.error("任务调度被中断");
            }
        }
    }
}
