package example.my_example.thread_example.semaphore_tread.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Passenger implements Runnable {

    private String passengerName;
    private CountDownLatch countDownLatch;

    public Passenger(String passengerName, CountDownLatch countDownLatch) {
        this.passengerName = passengerName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            System.out.println("-> " + passengerName + " прибыл в аэропорт");
            Thread.sleep(100);
            System.out.println("!!" + passengerName + " сдал багаж");
            Thread.sleep(500);
            System.out.println("!!" + passengerName + " перекусил");
            Thread.sleep(200);
            countDownLatch.countDown();

            countDownLatch.await(10, TimeUnit.SECONDS);
            System.out.println(" " + passengerName + " полетел");

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
