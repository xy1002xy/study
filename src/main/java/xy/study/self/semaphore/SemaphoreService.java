package xy.study.self.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @program: demo
 * @description: 测试semaphore方法
 * @author: wxy
 * @create: 2020-01-28 18:14
 **/
@Slf4j
public class SemaphoreService {
    private Semaphore semaphore = new Semaphore(1);

    public void testSemaphore() {
        try {
            semaphore.acquire();
            log.info("当前线程名称{},当前开始时间为{}", Thread.currentThread().getName(), System.currentTimeMillis());
          //  Thread.sleep(500);
            log.info("当前线程名称{},当前截止时间为{}", Thread.currentThread().getName(), System.currentTimeMillis());
            semaphore.release();
        }
        catch (InterruptedException e) {
            log.info("当前线程名称{},获取到的异常{}", Thread.currentThread().getName(), e.getMessage());
            e.printStackTrace();
        }
    }
}
