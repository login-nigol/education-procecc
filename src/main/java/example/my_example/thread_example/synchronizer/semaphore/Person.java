package example.my_example.thread_example.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class Person implements Runnable {

    private String name;
    private Semaphore semaphore;
    private boolean[] freeTables;

    public Person(String name, Semaphore semaphore, boolean[] freeTables) {
        this.name = name;
        this.semaphore = semaphore;
        this.freeTables = freeTables;
    }

    @Override
    public void run() {

        System.out.println(" -> " + name + " пришел(а) в ресторан");
        // поток пойдёт за эту строчку или переведёт в состояние ожидания
        try {
            semaphore.acquire(); // 5, 4, ->, 0 // if count == 0 then wait, запрос доступа
            int index = -1;
            // если счётчик семафора больше 0, то поток продолжает работать здесь
            synchronized (freeTables) {
                for (int i = 0; i < freeTables.length; i++) {
                    if (!freeTables[i]) {
                        freeTables[i] = true;
                        index = i;
                        System.out.println("!!! " + name + " занял(а) столик " + (i + 1));
                        break;
                    }
                }
            }
            Thread.sleep(5000);

            synchronized (freeTables) {
                freeTables[index] = false;
            }
            semaphore.release(); // count++; notifyAll();

            System.out.println("<- " + name + " освободил(а) стол и покинул(а) ресторан");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
