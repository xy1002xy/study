package xy.study.self.singleton;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-07 23:23
 * @desc: 测试单例模式中的内部类 线程安全，调用效率高，并且实现的延时加载
 **/
public class Demo4 {
    public Demo4() {
    }
    //只有调用getInstance方法时才会调用内部类
    private static class SingletonDemo4{
        private static final Demo4 instance=new Demo4();
    }

    public static Demo4 getInstance(){
       return SingletonDemo4.instance;
    }

}
