package xy.study.self.semaphore;

/**
 * @program: demo
 * @description: 线程A
 * @author: wxy
 * @create: 2020-01-28 18:20
 **/
public class ThreadA extends Thread {
    private SemaphoreService semaphoreService;

    public ThreadA(SemaphoreService semaphoreService) {
        super();
        this.semaphoreService = semaphoreService;
    }

    @Override
    public void run() {
        semaphoreService.testSemaphore();
    }
}
