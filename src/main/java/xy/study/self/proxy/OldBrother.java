package xy.study.self.proxy;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-10 21:25
 * @desc:
 **/
public class OldBrother implements Study {
    @Override
    public void read() {
        System.out.println("老哥哥正在读书！");
    }

    @Override
    public void write() {
        System.out.println("老哥哥正在写作业");
    }
}
