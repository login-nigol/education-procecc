package example.my_example.thread_example.pool_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// пул потоков с фиксированным количеством потоков
public class ExecutorFixedThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 15; i++){
            executorService.submit(new Printer(i));
            System.out.println("Add printer with number " + i + " to pool");
        }

        executorService.shutdown();
    }
}
