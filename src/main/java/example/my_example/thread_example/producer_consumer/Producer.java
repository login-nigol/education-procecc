package example.my_example.thread_example.producer_consumer;


import java.util.Random;

public class Producer implements Runnable {

    private SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {

            synchronized (sharedBuffer) {
                for (int i = 0; i < 100; i++) {
                    int number = random.nextInt(100);
                    sharedBuffer.put(number);
                    System.out.println("put " + number);
                }
                sharedBuffer.notifyAll();
                System.out.println();
                try {
                    sharedBuffer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            sleep(1000);
        }

    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
