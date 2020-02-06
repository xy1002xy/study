package xy.study.self.demo.complex;

import java.util.Collection;
import java.util.HashSet;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 21:04
 * @desc: 单纯的继承
 **/
public class InstrumentedHashSet <E> extends HashSet<E> {

    private int addCount=0;

    public InstrumentedHashSet(){

    }

    public InstrumentedHashSet( int initCap,int loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount +=c.size();
//        for (E e:c){
//           return super.add(e);
//        }
       return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
