package com.xy.test;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-09 12:57
 * @desc:
 **/
public class SimpleServer extends Server {
    private int port=100;

    //初始化传递一个端口号
    public SimpleServer (int _port){
        System.out.println("=========333333========");
        port=_port;
    }

    //检查端口号是否有效，无效使用默认端口，这里使用随机数模拟
    @Override
    protected int getPort() {
        System.out.println("=======SimpleServer类的getPort()方法========");
        return Math.random()>0.5?port:DEFAULT_PORT;
    }
}
