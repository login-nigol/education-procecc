package example.my_example.thread_example.bread_factory_task;

import java.util.concurrent.Semaphore;

class Store implements Runnable {

    private final Semaphore storeSemaphore;
    private final Semaphore factorySemaphore;

    public Store(Semaphore storeSemaphore, Semaphore factorySemaphore) {
        this.storeSemaphore = storeSemaphore;
        this.factorySemaphore = factorySemaphore;
    }

    @Override
    public void run() {

        try {
            storeSemaphore.acquire();  // ждём сигнала для работы магазина

            System.out.println("Магазин: Продажа хлеба...");
            Thread.sleep(1000);

            System.out.println("Магазин: Хлеб продан.");
            Thread.sleep(1000);

            factorySemaphore.release();  // передаём управление заводу

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
//while (BreadProduction.cycleCount < BreadProduction.MAX_CYCLES) {
//BreadProduction.cycleCount++;  // увеличиваем счётчик циклов