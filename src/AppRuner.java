import java.util.concurrent.locks.ReentrantLock;

/*Сергей Гусельников
Необходимо реализовать коллекцию, которая имеет фиксированный размер.

Размер задаётся:

    по умолчанию 16
    по указанию пользователя.

Размер коллекции после инициализации меняться не может.

Каждый новый элемент добавляется в конец. После того, как количество элементов достигло максимума -
при добавлении нового элемента коллекция "сдвигается" влево.

1-й элемент удаляется, а каждый следующий смещается на один элемент влево.

Результатом выполнения задания должен быть репозиторий с коллекцией, классом, тестирующим данную коллекцию,
описанием задания и README файлом с инструкцией по запуску приложения

UPD: Необходимо внести изменения в задание к модулю 1.2 (Очередь) таким образом, чтобы данный класс стал многопоточным (потоко-безопасным).
 */
public class AppRuner {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать");

        MyQueue q1 = new MyQueue();
        MyQueue q2 = new MyQueue(5);
        ReentrantLock locker = new ReentrantLock();

        MyQueueDemo demo = new MyQueueDemo(q1, locker);

        try {
            Thread t = new Thread(demo);
            t.setName("Демонстрационный поток 1");
            t.start();

            Thread t2 = new Thread(new MyQueueDemo(q2, locker));
            t2.setName("Демонстрационный поток 2");
            t2.start();


            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("До свидания!");
    }
}
