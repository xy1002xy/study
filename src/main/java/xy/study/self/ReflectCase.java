package xy.study.self;

import java.lang.reflect.Method;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-25 19:17
 * @desc: 反射测试用例
 **/
public class ReflectCase {
    static class Proxy{
        public void run(){
            System.out.println("方法run()");
        }
    }

    public static void main(String[] args) throws Exception {
        Proxy target=new Proxy();
        Method method=Proxy.class.getDeclaredMethod("run");
        method.invoke(target);
    }
}
