package xy.study.self.adapter.InterfaceAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:19
 * @desc:
 **/
public class Complex extends AbstractCalculate {
    private static final Logger logger= LoggerFactory.getLogger(AbstractCalculate.class);

    @Override
    public void add() {
        logger.info("我是加法运算方式");
    }

    @Override
    public void reduce() {
        logger.info("我是减法运算方式");
    }

    @Override
    public void multiply() {
        logger.info("我是乘法运算方式");
    }

    @Override
    public void division() {
        logger.info("我是除法运算方式");
    }
}
