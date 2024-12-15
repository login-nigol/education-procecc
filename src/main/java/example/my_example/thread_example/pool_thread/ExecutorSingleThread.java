package example.my_example.thread_example.pool_thread;

import java.util.concurrent.*;

// одно поточный пул потоков
public class ExecutorSingleThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Printer());
        Thread.sleep(1000);
        executorService.execute(new Handler());

        Calculator calculator = new Calculator();
//        new Thread(calculator).start(); // не стартует через простой поток
        Future<String> futureResult = executorService.submit(calculator);

        String string = null;
        try {
            string = futureResult.get(10, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            futureResult.cancel(true);
        }
        System.out.println(string);

        executorService.shutdown();
    }
}