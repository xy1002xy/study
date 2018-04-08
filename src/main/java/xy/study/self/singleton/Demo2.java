package xy.study.self.singleton;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-07 23:20
 * @desc: 测试单例模式中的懒汉式
 **/
public class Demo2 {

    public Demo2() {
    }

    //类初始化时，延迟加载对象，加载类时没有线程安全
    private static Demo2 instance;
    //用同步方法，所以效率不高
    public synchronized static Demo2 getInstance(){
        if (instance==null){
            instance=new Demo2();
        }
        return instance;
    }
}
