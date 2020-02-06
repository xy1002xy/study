package xy.study.self.demo.complex;

import java.util.Collection;
import java.util.HashSet;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 21:04
 * @desc:   组合
 **/
public class InstrumentedHashSetCom <E> {
    int addCount=0;
    HashSet hashSet=new HashSet();

    public boolean add(E e){
        addCount++;
        return hashSet.add(e);
    }

    public boolean addAll(Collection<? extends E> c){
        addCount +=c.size();
        return hashSet.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
