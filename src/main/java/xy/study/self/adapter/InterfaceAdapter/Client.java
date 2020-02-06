package xy.study.self.adapter.InterfaceAdapter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 21:21
 * @desc:
 **/
public class Client {

    public static void main(String[] args) {

        SumInterface sum=new Sample();
        sum.add();
        sum.reduce();
    }
}
