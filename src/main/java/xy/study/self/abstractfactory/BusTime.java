package xy.study.self.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:51
 * @desc:
 **/
public class BusTime implements Timer{
    private static final Logger logger= LoggerFactory.getLogger(BusTime.class);

    public BusTime() {
        logger.info("要花我将近4个小时的时间");
    }
}
