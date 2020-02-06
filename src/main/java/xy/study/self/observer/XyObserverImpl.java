package xy.study.self.observer;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 20:29
 * @desc:
 **/
public class XyObserverImpl implements XyObserver {

    private String message;
    private String name;

    public XyObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message=message;
        receive();
    }

    public void receive(){
        System.out.println(name+"===观察者收到推送的更新消息===="+message);
    }

}
