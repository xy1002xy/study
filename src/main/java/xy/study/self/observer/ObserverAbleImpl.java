package xy.study.self.observer;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 20:18
 * @desc: 被观察者
 **/

public class ObserverAbleImpl implements Observerable {

    List<XyObserver>list=new ArrayList<>();
    private String message;

    private XyObserver xyObserver;

    public ObserverAbleImpl() {
        list=new ArrayList<XyObserver>();
    }

    public ObserverAbleImpl(List<XyObserver> xyObserverList) {
        for (XyObserver xyObserver:xyObserverList){
            this.xyObserver = xyObserver;
            list.add(this.xyObserver);
        }

    }

    @Override
    public void registerObserver(XyObserver observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(XyObserver observer) {
        if (!CollectionUtils.isEmpty(list)){
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (XyObserver xyObserver:list){
            XyObserver xy=xyObserver;
            xy.update(message);
        }
    }

    public void sendMessage(String str){
        this.message=str;
        System.out.println("==========消息更新: "+str);

        //消息更新，通知所有观察者
        notifyObserver();
    }

}
