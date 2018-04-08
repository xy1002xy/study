package com.xy.runnableTest;


import org.apache.log4j.Logger;

import java.util.concurrent.*;

/**
    * @Author: wxy
    * @Date: 2018/3/3 16:29
    * @Params:
    * @description: ThreadPool 线程池
    * @Return:
    **/
public class ThreadPool {



//    public ThreadPoolExecutor(int corePoolSize,
//                              int maximumPoolSize,
//                              long keepAliveTime,
//                              TimeUnit unit,
//                              BlockingQueue<Runnable> workQueue){
//        this(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,
//                Executors.defaultThreadFactory(),defaultHandler);
//    }



    public static void main(String[] args) {
        ExecutorService fixedThreadPool =Executors. newFixedThreadPool(3);
        for (int i =1; i<=5;i++){
            final int index=i ;
            fixedThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    try {
                        System.out.println("第" +index + "个线程" +Thread.currentThread().getName());
                        Thread.sleep(5000);
                    } catch(InterruptedException e ) {
                        e .printStackTrace();
                    }
                }

            });
        }
    }




    }
