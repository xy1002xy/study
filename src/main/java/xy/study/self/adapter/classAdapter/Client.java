package xy.study.self.adapter.classAdapter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-12 20:54
 * @desc: 测试类适配器
 **/
public class Client {

    public static void main(String[] args) {

        ClassSource source=new ClassAdapter();
        source.buy();

    }
}
