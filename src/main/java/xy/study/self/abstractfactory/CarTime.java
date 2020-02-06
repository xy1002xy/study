package xy.study.self.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:51
 * @desc:
 **/
public class CarTime implements Timer{
    private static final Logger logger= LoggerFactory.getLogger(CarTime.class);

    public CarTime() {
        logger.info("要花我将近2个小时的时间");
    }
}
