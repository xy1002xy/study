package xy.study.self.singleton;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-08 22:01
 * @desc: 单例模式--双重锁机制
 **/
public class Demo3 {


    private static Demo3 instance=null;
    public static Demo3 getInstance(){
        if (instance==null){
            Demo3 sc;
            synchronized (Demo3.class){
                sc=instance;
                if (sc==null){
                    synchronized (Demo3.class){
                        if (sc==null){
                            sc=new Demo3();
                        }
                    }
                }
               instance=sc;
            }

        }
        return instance;
    }
}
