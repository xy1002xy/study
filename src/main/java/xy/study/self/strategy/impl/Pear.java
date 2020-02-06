package xy.study.self.strategy.impl;

import xy.study.self.strategy.Fruit;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-07 10:32
 * @desc:
 **/
public class Pear implements Fruit {
    @Override
    public void printPrice() {
        System.out.println("=====梨子的价格是5======");
    }
}
