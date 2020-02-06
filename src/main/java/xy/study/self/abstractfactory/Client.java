package xy.study.self.abstractfactory;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:56
 * @desc: ：测试抽象工厂的实例
 **/
public class Client {

    public static void main(String[] args) {
        ModeOneFactory modeOneFactory=new ModeOneFactory();
        modeOneFactory.vehicle();
        modeOneFactory.costTime();

        ModeTwoFactory modeTwoFactory=new ModeTwoFactory();
        modeTwoFactory.vehicle();
        modeTwoFactory.costTime();
    }
}
