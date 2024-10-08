package example.my_example.thread_example.priority_threads;

public class ThreadManager {

    private Thread[] threads;

    public ThreadManager(int numThreads) {
        threads = new Thread[numThreads];
    }

    // Создаем потоки и устанавливаем им приоритеты
    public void createThreads() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i + 1);
            // Устанавливаем приоритет от MIN_PRIORITY до MAX_PRIORITY
            threads[i].setPriority(i + 1);  // i + 1 задает приоритеты от 1 до 10
        }
    }

    // Запускаем потоки
    public void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
        System.out.println("Все потоки запущены");
    }

    // Ожидаем завершения всех потоков
    public void joinThreads() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все потоки завершены.");
    }
}
