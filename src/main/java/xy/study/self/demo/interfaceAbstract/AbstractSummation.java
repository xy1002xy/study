package xy.study.self.demo.interfaceAbstract;

import java.util.List;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-06 23:12
 * @desc: 骨架类
 **/
public abstract class AbstractSummation<T> implements ISummation<T>{


    @Override
    public abstract T towElementAdd(T obj01, T obj02);


    @Override
    public T listEleSum(List<T> list) {
        T firstEle = null;
        for (T t : list) {

            if (firstEle == null) {
                firstEle = t;
                continue;
            }

            firstEle = towElementAdd(firstEle, t);
        }
        return firstEle;
    }

    @Override
    public T arrayEleSum(T[] array) {
        T firstEle = null;
        for (T t : array) {

            if (firstEle == null) {
                firstEle = t;
                continue;
            }

            firstEle = towElementAdd(firstEle, t);
        }
        return firstEle;
    }

}
