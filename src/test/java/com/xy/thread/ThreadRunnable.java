package com.xy.thread;

    /**
    * @Author: wxy
    * @Date: 2018/3/1 19:34
    * @Params:
    * @description: 测试线程
    * @Return:
    **/
public class ThreadRunnable implements Runnable{

    private int i;
    public void run(){

        for (i=0;i<100;i++){
            System.out.println("当前线程名字是："+Thread.currentThread().getName()+" :"+i);
        }
    }

    public static void main(String[] args) {

        for (int i=0;i<100;i++){
            System.out.println("当前线程："+Thread.currentThread().getName()+" :"+i);
            if (i==20){
               ThreadRunnable tr=new ThreadRunnable();
              // Thread thread=new Thread(tr);
//                thread.start();
//                thread.start();

                new Thread(tr).start();
                new Thread(tr).start();

            }
        }

    }
}
