package xy.study.self.observer;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 20:15
 * @desc: 抽象观察者接口
 **/
public interface XyObserver {

    /**
     * 当被观察者调用推送消息时，观察者的update（）方法将会被回掉
     * @param message
     */
    void update(String message);
}
