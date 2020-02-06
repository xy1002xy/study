package xy.study.self.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @program: demo
 * @description: 测试semaphore方法
 * @author: wxy
 * @create: 2020-01-28 18:14
 **/
@Slf4j
public class SemaphoreExService {
    private Semaphore semaphore = new Semaphore(10);

    public void testSemaphore() {
        try {
            semaphore.acquire(2);
            log.info("当前线程名称{},当前开始时间为{}", Thread.currentThread().getName(), System.currentTimeMillis());
            int sleepValue = ((int) (Math.random() * 10000));
            log.info("当前线程名称{},停止时间为{}秒", Thread.currentThread().getName(), sleepValue/1000);
            Thread.sleep(500);
            log.info("当前线程名称{},当前截止时间为{}", Thread.currentThread().getName(), System.currentTimeMillis());
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
