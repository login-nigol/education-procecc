package example.my_example.thread_example.pool_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// динамический пул потоков
public class ExecutorCachedThread {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 15; i++){
            executorService.execute(new Printer(i));
            System.out.println("Add printer with number " + i + " to poll");
            Thread.sleep(100);
        }

        executorService.shutdown();
    }
}
