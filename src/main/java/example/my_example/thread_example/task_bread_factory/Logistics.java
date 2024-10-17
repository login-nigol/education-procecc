package example.my_example.thread_example.task_bread_factory;

import java.util.concurrent.Semaphore;

class Logistics implements Runnable {

    private final Semaphore logisticsSemaphore;
    private final Semaphore storeSemaphore;

    public Logistics(Semaphore logisticsSemaphore, Semaphore storeSemaphore) {
        this.logisticsSemaphore = logisticsSemaphore;
        this.storeSemaphore = storeSemaphore;
    }

    @Override
    public void run() {
        try {
            logisticsSemaphore.acquire();  // ждём сигнала для работы логистики

            System.out.println("Логистика: Доставка хлеба...");
            Thread.sleep(1000);

            System.out.println("Логистика: Хлеб доставлен, разгрузка в магазине");
            Thread.sleep(1000);

            storeSemaphore.release();  // передаём управление магазину

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

