package xy.study.self.strategy;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-11-07 10:34
 * @desc: 策略环境，输出水果价格
 **/
public class FruitPrice {

    /**
     * 策略对象
     */
    private Fruit fruit;

    /**
     * @param fruit 策略对象
     */
     public FruitPrice(Fruit fruit){
         this.fruit=fruit;
     }

    /**
     * 输出各个水果的价格
     */
     public void fruitPrice(){
         fruit.printPrice();
     }

}
