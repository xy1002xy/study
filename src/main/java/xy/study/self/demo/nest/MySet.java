package xy.study.self.demo.nest;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-07 08:25
 * @desc:
 **/
public class MySet <E> extends AbstractSet<E> {



    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
