package xy.study.self.demo.complex;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 23:56
 * @desc: 转发(fowarding):新类中的每个实例方法都可以调用被包含的现有类实例中对应的方法，并返回结果。
 **/
public class ForwardingSet <E> implements Set<E> {

    /**
     * 引用现有类的实例，增加私有域
     */
    private final Set<E> set;
    public ForwardingSet(Set<E> set) {
        this.set=set;
    }

    /**
     *
     转发方法
     */
    @Override
    public boolean add(E e) {
        return set.add(e);
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }



    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
