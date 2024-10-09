package example.my_example.thread_example.multi_threading;

public class SynchCounter {

    private int counter;

    private final Object mutex = new Object();

    public void increment() {
//        counter++;
        synchronized (mutex) {
            int tmp = counter;
            tmp = tmp + 1;
            counter = tmp;
        }
    }


    public static void main(String[] args) {
        SynchCounter synchCounter = new SynchCounter();
//        synchCounter.increment();

        SynchCounter synchCounter2 = new SynchCounter();
        synchCounter2.increment();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchCounter.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchCounter.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(synchCounter.counter);
    }

}
