public class MyQueueDemo {
    MyQueue q1 = new MyQueue();
    MyQueue q2 = new MyQueue(5);

    public MyQueueDemo() {
    }

    public void startDemo() {
        for (int i = 0; i < q1.size(); i++) {
            q1.add(i);
        }

        System.out.println("Коллекция с размером по умолчанию:");
        System.out.println(q1);
        System.out.println("После добавления элемента в заполненную коллекцию:");
        q1.add(99);
        System.out.println(q1);

        for(int i = 0; i < q2.size(); i++) {
            q2.add(i);
        }

        System.out.println("Коллекция с размером по умолчанию:");
        System.out.println(q2);
        System.out.println("После добавления элемента в заполненную коллекцию:");
        q2.add(99);
        System.out.println(q2);
    }
}
