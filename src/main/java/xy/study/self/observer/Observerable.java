package xy.study.self.observer;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 20:07
 * @desc: 抽象被观察者接口  声明了添加，删除，通知观察者方法
 **/
public interface Observerable {
    /**
     *  注册的观察者（关注公众号）里面是存放注册的观察者列表
     * @param observer
     */
    void registerObserver(XyObserver observer);

    /**
     * 移除观察者（取消关注）从列表中移除
     * @param observer
     */
    void removeObserver(XyObserver observer);

    /**
     * 通知消息（推送消息）
     */
    void notifyObserver();

}
