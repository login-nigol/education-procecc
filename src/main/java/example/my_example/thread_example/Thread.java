package example.my_example.thread_example;

public class Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread");
        }
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}

class MyThread extends java.lang.Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("my thread");
        }
    }
}

