package xy.study.self.demo.interfaceAbstract;

import java.util.List;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-06 23:15
 * @desc: 加法一些接口
 **/

public interface ISummation<T> {

    /**
     *
     * @param obj01
     * @param obj02
     * @return 实现两个对象的相加(基本方法)
     */
    T towElementAdd(T obj01, T obj02);

    /**
     *
     * @param list
     * @return 实现List求和
     */
    T listEleSum(List<T> list);

    /**
     *
     * @param array
     * @return 实现数组求和
     */
    T arrayEleSum(T[] array);

    default void testMethod(){

    }


}
