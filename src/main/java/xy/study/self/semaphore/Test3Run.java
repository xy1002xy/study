package xy.study.self.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @program: demo
 * @description: 测试线程
 * @author: wxy
 * @create: 2020-01-28 18:24
 **/
@Slf4j
public class Test3Run {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        try {
            semaphore.acquire();
//            semaphore.acquire();
//            semaphore.acquire();
//            semaphore.acquire();
//            semaphore.acquire();
            log.info("可用的许可数量{}", semaphore.availablePermits());
            log.info("semaphore.drainPermits(),返回立即可用的所有permits个数，并将可用permits置为0,==>{} , 可用的许可数量{}",
                    semaphore.drainPermits(), semaphore.availablePermits());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            log.info("可用的许可数量{}", semaphore.availablePermits());
            semaphore.release(4);
            log.info("可用的许可数量{}", semaphore.availablePermits());
        }
    }
}
