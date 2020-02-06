package xy.study.self.demo.interfaceAbstract;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-06 23:22
 * @desc:
 **/
public class SummationClass extends AbstractSummation <Integer>{


    @Override
    public Integer towElementAdd(Integer obj01, Integer obj02) {
        return obj01+obj02;
    }



    public static void main(String[] args) {
        SummationClass summationClass=new SummationClass();

    }
}
