package xy.study.self;

import xy.study.self.singleton.*;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-08 22:20
 * @desc:  测试单例模式的几种写法
 **/
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("==============懒汉式单例模式==================");
        Demo1 demo1=Demo1.getInstance();
        Demo1 demo2=Demo1.getInstance();
        System.out.println(demo1==demo2);
        System.out.println("===============饿汉式单例模式==================");
        Demo2 demo3=Demo2.getInstance();
        Demo2 demo4=Demo2.getInstance();
        System.out.println(demo3==demo4);
        System.out.println("================内部类单例模式=================");
        Demo4 demo5=Demo4.getInstance();
        Demo4 demo6=Demo4.getInstance();
        System.out.println(demo5==demo6);
        System.out.println("================枚举单例模式=================");
        Demo5 demo7=Demo5.INSTANCE;
        Demo5 demo8=Demo5.INSTANCE;
        System.out.println(demo7==demo8);
        System.out.println("================双重锁模式=================");
        Demo3 de1=Demo3.getInstance();
        Demo3 de2=Demo3.getInstance();
        System.out.println(de1==de2);


    }
}
