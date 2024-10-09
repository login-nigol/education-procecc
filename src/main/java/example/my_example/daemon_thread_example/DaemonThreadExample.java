package example.my_example.daemon_thread_example;

import java.time.LocalDateTime;

public class DaemonThreadExample {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(Runtime.getRuntime().availableProcessors() / 2);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Runnable task = new Task();
        Thread thread1 = new Thread(task, "MyThread1");
        Thread thread2 = new Thread(task, "MyThread2");
        thread1.start();
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " counter = " + counter++ + ", time: "
                                + LocalDateTime.now());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread3.setDaemon(true);
        thread3.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " works");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

