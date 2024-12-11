package example.my_example.thread_example.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

// синхронизатор semaphore, ограничение доступа к объекту определённым количеством потоков
public class SemaphoreApp {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(5, true);

        boolean[] freeTables = new boolean[5];

        String[] person = {"Roman", "Elena", "Ivan", "Egor", "Anna", "Leo", "Bob", "Vika"};

        // создаю 8 потоков
        for (int i = 0; i < person.length; i++) {
            new Thread(new Person(person[i], semaphore, freeTables)).start();
            Thread.sleep(700);
        }
    }
}
