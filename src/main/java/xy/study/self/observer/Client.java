package xy.study.self.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 20:33
 * @desc: 测试观察者模式
 **/
public class Client {

    public static void main(String[] args) {

        XyObserver xy=new XyObserverImpl("xy");
        XyObserver yp=new XyObserverImpl("yp");
        XyObserver yl=new XyObserverImpl("yl");

        List<XyObserver> user=new ArrayList<>();
        user.add(xy);
        user.add(yp);
        user.add(yl);
        ObserverAbleImpl observerAble=new ObserverAbleImpl(user);
        observerAble.sendMessage("测试更新数据之后有什么效果");
        System.out.println("=====================分割线=======================");
        observerAble.removeObserver(yp);
        observerAble.sendMessage("测试一个人取消订阅之后，然后更新数据之后有什么效果");
    }
}
