package example.my_example.thread_example.multi_threading;

public class SynchBlockExample {

    static Object mutex = new Object();


    public static void main(String[] args) {
        Runnable task = new Task();
        Thread thread1 = new Thread(task, "MyThread1");
        Thread thread2 = new Thread(task, "MyThread2");
        thread1.start();
        thread2.start();

        synchronized (mutex) {
            System.out.println(Thread.currentThread().getName() + " in synch block");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " left synch block");
    }


    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " runs");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + " in synch block");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " left synch block");
        }
    }
}
