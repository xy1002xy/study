
package com.xy.aop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * @program: girl
 * @author: wxy
 * @create: 2018-11-03 11:58
 * @desc:
 **/
@Service
public class SomeService {
    private Logger logger= LoggerFactory.getLogger(getClass());
    private Random random=new Random(System.currentTimeMillis());

    public void someMethod(){
        logger.info("============222222222222222============");
        logger.info("====SomeService:someMethod invoked===");
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
