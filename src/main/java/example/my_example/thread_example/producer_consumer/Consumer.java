package example.my_example.thread_example.producer_consumer;

public class Consumer implements Runnable {

    private SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        sleep();
        while (true) {
            synchronized (sharedBuffer) {
                if (!sharedBuffer.isEmptyQueue()) {
                    int number = sharedBuffer.get();
                    System.out.println("thread name is " + Thread.currentThread().getName() +
                            " get " + number);
                } else {
                    sharedBuffer.notify();
                    try {
                        sharedBuffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
