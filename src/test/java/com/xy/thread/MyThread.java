package com.xy.thread;

    /**
    * @Author: wxy
    * @Date: 2018/3/1 19:34
    * @Params:
    * @description: 测试线程
    * @Return:
    **/
public class MyThread extends Thread{

    int i=0;
    public void run(){

        for (;i<100;i++){
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) {

        for (int i=0;i<100;i++){
            System.out.println("当前线程："+Thread.currentThread().getName()+" :"+i);
            if (i==20){
               // new MyThread().start();
                new MyThread().start();
                new MyThread().start();

            }
        }

    }
}
