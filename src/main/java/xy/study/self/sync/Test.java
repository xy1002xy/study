package xy.study.self.sync;

/**
 * @program: sell
 * @description: 测试
 * @author: wxy
 * @create: 2020-01-10 17:28
 **/
public class Test {

        public void syncBlock(){
            synchronized (this){
                System.out.println("hello block");
            }
        }
        public synchronized void syncMethod(){
            System.out.println("hello method");
        }

}
