package example.my_example.thread_example.synchronizer.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Passenger implements Runnable {

    private String name;
    private CountDownLatch countDownLatch;

    public Passenger(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            System.out.println("-> " + name + " прибыл в аэропорт");
            Thread.sleep(300);
            System.out.println("!! " + name + " сдал багаж");
            Thread.sleep(300);
            System.out.println("!! " + name + " зарегистрировался");
            Thread.sleep(300);

            countDownLatch.countDown();

            // усыпляет сам себя, (пробуждает поток даже если меньше указанного параметра потоков синхронизатора)
            countDownLatch.await(10, TimeUnit.SECONDS);
            System.out.println("<- " + name + " полетел");

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
