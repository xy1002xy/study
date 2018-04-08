package com.xy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
    * @Author: wxy
    * @Date: 2018/3/1 19:34
    * @Params:
    * @description: 测试线程
    * @Return:
    **/
public class CallableThread implements Callable {

    int i=0;



    public static void main(String[] args) {

        CallableThread ct=new CallableThread();
        FutureTask<Integer>futureTask=new FutureTask<Integer>(ct);
        for (int i=0;i<100;i++){
            System.out.println("当前线程："+Thread.currentThread().getName()+"的循环变量值"+i);
            if (i==20){
                new Thread(futureTask,"有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程返回值："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Integer call() throws Exception {
            for (;i<100;i++){
                System.out.println(Thread.currentThread()+" "+i);
            }
        return i;
    }
}
