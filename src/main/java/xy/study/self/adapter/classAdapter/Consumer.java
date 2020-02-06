package xy.study.self.adapter.classAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 20:57
 * @desc:
 **/
public class Consumer implements ClassTarget {

    private static final Logger logger=LoggerFactory.getLogger(Consumer.class);
    @Override
    public void storeShopping() {

        logger.info("虽然我在商城买不到，但是我可以在网上买到想买的东西！！！");
    }
}
