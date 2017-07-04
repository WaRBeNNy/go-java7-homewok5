import java.util.concurrent.locks.ReentrantLock;

public class MyQueueDemo implements Runnable{
    MyQueue q1;
    ReentrantLock locker;

    public MyQueueDemo(MyQueue q1, ReentrantLock lock) {
        this.q1 = q1;
        this.locker = lock;
    }

    public void run() {
        locker.lock();

        try {
            System.out.println(Thread.currentThread().getName());

            for (int i = 0; i < q1.size(); i++) {
                q1.add(i);
            }

            System.out.println("Коллекция с размером " + q1.size() + ":");
            System.out.println(q1);
            System.out.println("После добавления элемента в заполненную коллекцию:");
            q1.add(99);
            System.out.println(q1);

        } finally {
            locker.unlock();
        }
    }
}
