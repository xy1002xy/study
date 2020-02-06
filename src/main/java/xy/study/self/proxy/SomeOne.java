package xy.study.self.proxy;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-10 21:25
 * @desc:
 **/
public class SomeOne implements Study {
    @Override
    public void read() {
        System.out.println("某人正在读书！");
    }

    @Override
    public void write() {
        System.out.println("某人正在写作业");
    }
}
