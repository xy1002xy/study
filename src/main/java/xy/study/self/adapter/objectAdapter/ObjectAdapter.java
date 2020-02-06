package xy.study.self.adapter.objectAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 20:51
 * @desc: 类适配器
 **/
public class ObjectAdapter  implements ObjectSource {


    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectAdapter.class);

    private ObjectTarget objectTarget;

    public ObjectAdapter(ObjectTarget objectTarget) {
        this.objectTarget = objectTarget;
    }

    @Override
    public void buy() {
        LOGGER.info("我可以在商城购买东西，但是有些东西买不到");
        objectTarget.storeShopping();
    }
}
