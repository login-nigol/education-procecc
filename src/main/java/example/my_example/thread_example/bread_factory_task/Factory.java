package example.my_example.thread_example.bread_factory_task;

import java.util.concurrent.Semaphore;

class Factory implements Runnable {
    private final Semaphore factorySemaphore;
    private final Semaphore logisticsSemaphore;

    public Factory(Semaphore factorySemaphore, Semaphore logisticsSemaphore) {
        this.factorySemaphore = factorySemaphore;
        this.logisticsSemaphore = logisticsSemaphore;
    }

    @Override
    public void run() {
        try {
            factorySemaphore.acquire();  // ждём сигнала для работы завода

            System.out.println("Завод: Выпекаем хлеб...");
            Thread.sleep(1000);

            System.out.println("Завод: Хлеб готов, отправляется на доставку");
            Thread.sleep(1000);

            logisticsSemaphore.release();  // передаём управление логистике

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

