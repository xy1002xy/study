package xy.study.self.singleton;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-07 23:09
 * @desc: 测试单例模式中的饿汉式
 **/
public class Demo1 {

    public Demo1() {
    }
    //类初始化时立即加载这个对象，加载类时天然时线程安全的
    private static Demo1 instance=new Demo1();
    //不需要同步方法，效率高
    public static  Demo1 getInstance(){
        return instance;
    }
}
