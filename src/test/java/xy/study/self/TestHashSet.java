package xy.study.self;

import xy.study.self.demo.complex.InstrumentedHashSet;
import xy.study.self.demo.complex.InstrumentedHashSetCom;
import xy.study.self.demo.complex.InstrumentedHashSetEg;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 21:33
 * @desc:
 **/
public class TestHashSet {

    public static void main(String[] args) {
        //单纯的继承
        InstrumentedHashSet<String> s=new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("哈哈哈","嘎嘎嘎","啊啊啊"));
        System.out.println("======使用继承添加元素的个数======="+s.getAddCount());

        //通过组合的方式
        InstrumentedHashSetCom<String> str=new InstrumentedHashSetCom<String>();
        str.addAll(Arrays.asList("哈哈哈","嘎嘎嘎","啊啊啊"));
        System.out.println("======使用复合添加元素的个数======="+str.getAddCount());
    }
}
