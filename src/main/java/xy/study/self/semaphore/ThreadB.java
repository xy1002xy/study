package xy.study.self.semaphore;

/**
 * @program: demo
 * @description: 线程B
 * @author: wxy
 * @create: 2020-01-28 18:20
 **/
public class ThreadB extends Thread {
    private SemaphoreService semaphoreService;

    public ThreadB(SemaphoreService semaphoreService) {
        super();
        this.semaphoreService = semaphoreService;
    }

    @Override
    public void run() {
        semaphoreService.testSemaphore();
    }
}
