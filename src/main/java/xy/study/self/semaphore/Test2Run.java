package xy.study.self.semaphore;

/**
 * @program: demo
 * @description: 测试线程
 * @author: wxy
 * @create: 2020-01-28 18:24
 **/
public class Test2Run {

    public static void main(String[] args) {
        SemaphoreExService semaphoreService = new SemaphoreExService();
        ThreadExA[] threadA = new ThreadExA[10];
        for (int i = 0; i < 10; i++) {
            threadA[i]=new ThreadExA(semaphoreService);
            threadA[i].setName("线程"+i);
            threadA[i].start();
        }


    }
}
