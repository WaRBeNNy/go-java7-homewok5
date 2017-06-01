import java.util.Arrays;


public class MyQueue {
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

    public int size() {
        return this.size;
    }

    public boolean add(Object o) {
        checkSize();
        coll[n] = o;
        n++;
        return false;
    }

    private void checkSize() {
        if (n == size) {
            for (int i = 0; i < n-2; i ++) {
                coll[i] = coll[i+1];
            }
            n--;
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "coll=" + Arrays.toString(coll) +
                ", size=" + size +
                '}';
    }
}
