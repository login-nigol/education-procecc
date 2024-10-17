package example.my_example.thread_example.tread_pool;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TPEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 55; i++) {
            service.execute(new RImpl());
        }

        service.shutdown();
        service.awaitTermination(2, TimeUnit.SECONDS);

    }
}


class RImpl implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(222);
            System.out.println("TN: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}