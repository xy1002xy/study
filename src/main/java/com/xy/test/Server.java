package com.xy.test;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-09 12:57
 * @desc:
 **/
abstract class Server {
    public final static int DEFAULT_PORT=40000;
    public Server(){
        System.out.println("=========调用父类的构造函数========");
        // 获得子类提供的端口号
        int port=getPort();
        System.out.println(" 端口号："+port);
        /* 进行监听工作*/
    }

    // 由子类提供端口号，并做可用性检查
    protected abstract int getPort();
}
