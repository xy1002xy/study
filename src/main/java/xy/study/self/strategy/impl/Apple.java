package xy.study.self.strategy.impl;

import xy.study.self.strategy.Fruit;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-07 10:31
 * @desc:
 **/
public class Apple implements Fruit {
    @Override
    public void printPrice() {
        System.out.println("=====苹果的价格是10=====");
    }
}
