package xy.study.self.semaphore;

/**
 * @program: demo
 * @description: 线程c
 * @author: wxy
 * @create: 2020-01-28 18:20
 **/
public class ThreadC extends Thread {
    private SemaphoreService semaphoreService;

    public ThreadC(SemaphoreService semaphoreService) {
        super();
        this.semaphoreService = semaphoreService;
    }

    @Override
    public void run() {
        semaphoreService.testSemaphore();
    }
}
