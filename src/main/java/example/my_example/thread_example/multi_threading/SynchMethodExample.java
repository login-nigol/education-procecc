package example.my_example.thread_example.multi_threading;

public class SynchMethodExample {

    public static void main(String[] args) {
        SynchMethodExample example = new SynchMethodExample();

        new Thread(() -> example.method()).start();
        new Thread(() -> example.method2()).start();
        new Thread(() -> example.method2()).start();

        synchronized (example) {
            System.out.println("Some action in main");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        new Thread(() -> SynchMethodExample.staticMethod()).start();

        synchronized (SynchMethodExample.class) {
            System.out.println("Some action2 in main");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void method() {
//        synchronized (this) {
        System.out.println(Thread.currentThread().getName() + " in synch method");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " in synch method2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void staticMethod() {
//        synchronized (SynchMethodExample.class) {
        System.out.println(Thread.currentThread().getName() + " in static synch method");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }
}
