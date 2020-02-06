package xy.study.self.strategy.impl;

import xy.study.self.strategy.Fruit;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-07 10:33
 * @desc:
 **/
public class Banana implements Fruit {
    @Override
    public void printPrice() {
        System.out.println("=====香蕉的价格是3=====");
    }
}
