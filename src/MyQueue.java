import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class MyQueue implements Queue{
    private Object []coll;
    private int size;
    private int n=0;
    private int MAX_SIZE = 16;

    public MyQueue() {
        this.size = MAX_SIZE;
        this.coll = new Object[MAX_SIZE];
    }

    public MyQueue(int size) {
        this.size = size;
        this.coll = new Object[size];
    }

    public synchronized int size() {
        return this.size;
    }

    @Override
    public synchronized boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public synchronized boolean contains(Object o) {
        for (int i=0; i < n; i++) {
            if (o.equals(coll[i]))
                return true;
        }
        return false;
    }

    @Override
    public synchronized Iterator iterator(){
        return new MyIterator(0);
    }

    @Override
    public synchronized Object[] toArray() {
        return coll;
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        if (a.length < size)
            return (Object[]) Arrays.copyOf(coll, size, a.getClass());
        System.arraycopy(coll, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public synchronized boolean add(Object o) {
        checkSize();
        coll[n] = o;
        n++;
        return true;
    }

    @Override
    public synchronized boolean remove(Object o) {
        int index;

        for (int i = 0; i < n ; i++) {
            if (o.equals(coll[i])) {
                index = i;
                for (int j = index; j < n - 1; j++) {
                    coll[j] = coll [j +1];
                }
                coll[n--] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        for (Object o: c ) {
            add(o);
        }
        return true;
    }

    @Override
    public synchronized void clear() {
        for (int i=0; i < n; i++)
            coll[i] = null;

        n = 0;
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        int count = 0;

        for (int i = 0; i < n; i ++) {
                if ( !c.contains(coll[i])) {
                    remove(coll[i]);
                    count++;
                }
        }

        return count > 0;
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        int count = 0;

        for (Object o : c) {
            if(contains(o)) {
               remove(o);
               count++;
            }
        }

        return count > 0;
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        int count = 0;
        for(Object o : c) {
           if(contains(o))
               count++;
        };
        if(count == c.size())
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean offer(Object o) {
        return add(o);
    }

    @Override
    public synchronized Object remove() {
        Object last = coll[n];
        for (int i = 0; i < n-2; i ++) {
            coll[i] = coll[i+1];
        }
        coll[n--] = null;
        return last;
    }

    @Override
    public synchronized Object poll() {
        return remove();
    }

    @Override
    public synchronized Object element() {
        return coll[0];
    }

    @Override
    public synchronized Object peek() {
        return coll[0];
    }

    private synchronized void checkSize() {
        if (n == size) {
            for (int i = 0; i < n-2; i ++) {
                coll[i] = coll[i+1];
            }
            n--;
        }
    }

    @Override
    public synchronized String toString() {
        return "MyQueue{" +
                "coll=" + Arrays.toString(coll) +
                ", size=" + size +
                '}';
    }

    private class MyIterator implements Iterator {
        int current;

        MyIterator (int index) {
            this.current = index;
        }


        @Override
        public boolean hasNext() {
            return current != n;
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return coll[current+1];
            }
            return null;
        }
    }
}
