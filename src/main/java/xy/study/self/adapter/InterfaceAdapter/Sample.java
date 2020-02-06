package xy.study.self.adapter.InterfaceAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:20
 * @desc:
 **/
public class Sample extends AbstractCalculate {

    private static final Logger logger= LoggerFactory.getLogger(AbstractCalculate.class);

    @Override
    public void add() {
        logger.info("我是加法运算方式");
    }

    @Override
    public void reduce() {
        logger.info("我是减法运算方式");
    }
}
