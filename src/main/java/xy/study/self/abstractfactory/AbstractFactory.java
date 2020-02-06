package xy.study.self.abstractfactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:43
 * @desc:
 **/
public interface AbstractFactory {

    /**
     *
     * @return
     */
    Vehicle vehicle();

    /**
     *
     * @return
     */
    Timer costTime();
}
