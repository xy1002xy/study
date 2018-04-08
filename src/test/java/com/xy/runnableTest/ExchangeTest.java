package com.xy.runnableTest;


import org.apache.log4j.Logger;

import java.util.concurrent.*;

/**
    * @Author: wxy
    * @Date: 2018/3/3 16:29
    * @Params:
    * @description: 测试Exchange用法 ，两线程之间交换数据
    * @Return:
    **/
public class ExchangeTest  {

    protected static final Logger log=Logger.getLogger(ExchangeTest.class);
    private static volatile boolean isDone=false;

    static class ExchangerProducer implements Runnable{

        private Exchanger<Integer>exchanger;
        private static int data=1;

         ExchangerProducer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
             while (!Thread.interrupted() && !isDone){
                 for (int i=1;i<=3;i++){
                     try {
                         TimeUnit.SECONDS.sleep(1);
                         data=i;
                         System.out.println("produce before : "+data);
                         data=exchanger.exchange(data);
                         System.out.println("produce after : "+data);
                     } catch (InterruptedException e) {
                         log.error(e,e);
                     }
                 }
                 isDone=true;
             }

        }
    }

    static class ExchangerConsumer implements Runnable{

        private Exchanger<Integer>exchanger;
        private static int data=0;

        ExchangerConsumer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (!Thread.interrupted() && !isDone){
                data=0;
                System.out.println("consumer before : "+data);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data=exchanger.exchange(data);
                } catch (InterruptedException e) {
                    log.error(e,e);
                }
                System.out.println("consumer after : "+data);
            }
        }
    }



    public static void main(String[] args) {

        ExecutorService exse= Executors.newCachedThreadPool();
        Exchanger<Integer>exchanger=new Exchanger<>();
        ExchangerProducer producer=new ExchangerProducer(exchanger);
        ExchangerConsumer consumer=new ExchangerConsumer(exchanger);
        exse.execute(producer);
        exse.execute(consumer);
        exse.shutdown();

        try {
            exse.awaitTermination(30,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e,e);
        }


    }




    }
