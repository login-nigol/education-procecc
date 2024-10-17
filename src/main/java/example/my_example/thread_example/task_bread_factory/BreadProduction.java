package example.my_example.thread_example.task_bread_factory;

import java.util.concurrent.Semaphore;

public class BreadProduction {

    // Счётчик циклов (для ограничения до 3)
//        public static int MAX_CYCLES = 3;
//        public static int cycleCount = 0;

    public static void main(String[] args) {

        // Счётчик циклов (для ограничения до 3)
        int cycleCount = 0;
        int MAX_CYCLES = 3;

        // семафоры для управления потоками
        Semaphore factorySemaphore = new Semaphore(1);
        Semaphore logisticsSemaphore = new Semaphore(0);
        Semaphore storeSemaphore = new Semaphore(0);

        // Создание и запуск потоков
        new Thread(new Factory(factorySemaphore, logisticsSemaphore)).start();
        new Thread(new Logistics(logisticsSemaphore, storeSemaphore)).start();
        new Thread(new Store(storeSemaphore, factorySemaphore)).start();
    }
}


