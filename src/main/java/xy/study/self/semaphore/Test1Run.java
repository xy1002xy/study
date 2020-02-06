package xy.study.self.semaphore;

/**
 * @program: demo
 * @description: 测试线程
 * @author: wxy
 * @create: 2020-01-28 18:24
 **/
public class Test1Run {

    public static void main(String[] args) {
        SemaphoreService semaphoreService = new SemaphoreService();
        ThreadA threadA = new ThreadA(semaphoreService);
        threadA.setName("线程A");
        ThreadB threadB = new ThreadB(semaphoreService);
        threadB.setName("线程B");
        ThreadC threadC = new ThreadC(semaphoreService);
        threadC.setName("线程C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
