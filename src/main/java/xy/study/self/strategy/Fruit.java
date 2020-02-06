package xy.study.self.strategy;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-07 10:30
 * @desc: 水果有不同种类，每种水果对应不同价格，用策略模式实现。
 **/
public interface Fruit {
    /**
    * @Author: wxy
    * @Date: 2018/11/7 10:31
    * @description: Fruit
    * @Return:  返回不同水果对应的不同的价格
    **/
    void printPrice();
}
