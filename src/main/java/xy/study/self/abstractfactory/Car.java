package xy.study.self.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:48
 * @desc:
 **/
public class Car implements Vehicle{
    private static final Logger logger= LoggerFactory.getLogger(Car.class);

    public Car() {
        logger.info("我会开车去目的地");
    }
}
