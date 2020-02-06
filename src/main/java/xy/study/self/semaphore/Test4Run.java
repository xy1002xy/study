package xy.study.self.semaphore;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: demo
 * @description: 测试线程
 * @author: wxy
 * @create: 2020-01-28 18:24
 **/
@Slf4j
public class Test4Run {

    public static void main(String[] args) {
        SemaphoreService semaphoreService = new SemaphoreService();
        ThreadA threadA = new ThreadA(semaphoreService);
        threadA.setName("线程A");
        threadA.start();
        ThreadB threadB = new ThreadB(semaphoreService);
        threadB.setName("线程B");
        threadB.start();
        threadB.interrupt();
        log.info("==========线程B被中止===========");
    }
}
