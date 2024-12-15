package example.my_example.thread_example.pool_thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// планируемый пул потоков
public class ExecutorScheduledThread {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.schedule(new Printer(), (5+i), TimeUnit.SECONDS);
        }
        executorService.shutdown();
    }
}
