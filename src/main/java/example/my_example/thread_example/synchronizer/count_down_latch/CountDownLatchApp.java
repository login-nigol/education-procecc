package example.my_example.thread_example.synchronizer.count_down_latch;

import java.util.concurrent.CountDownLatch;

// синхронизатор
public class CountDownLatchApp {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        String[] person = {"Roman", "Elena", "Ivan", "Egor", "Anna", "Leo", "Bob", "Vika"};
        for (int i = 0; i < person.length; i++) {
            new Thread(new Passenger(person[i], countDownLatch)).start();
            Thread.sleep(700);
        }
    }
}
