package xy.study.self.abstractfactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:45
 * @desc:
 **/
public class ModeTwoFactory implements AbstractFactory {


    @Override
    public Vehicle vehicle() {
        return new Bus();
    }

    @Override
    public Timer costTime() {
    return new BusTime();

    }
}
