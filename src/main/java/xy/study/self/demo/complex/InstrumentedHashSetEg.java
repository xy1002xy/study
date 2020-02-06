package xy.study.self.demo.complex;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-05 23:26
 * @desc: /组合/转发 包装类(wrapper class),采用装饰者模式
 **/

public class InstrumentedHashSetEg<E> extends ForwardingSet<E> {

    private int addCount=0;

    public InstrumentedHashSetEg(Set<E>e){
        super(e);
    }

    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount +=c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
