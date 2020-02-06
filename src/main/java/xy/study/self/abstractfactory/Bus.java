package xy.study.self.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:48
 * @desc:
 **/
public class Bus implements Vehicle{
    private static final Logger logger= LoggerFactory.getLogger(Bus.class);

    public Bus() {
        logger.info("我要乘坐公交去目的地");
    }

}
