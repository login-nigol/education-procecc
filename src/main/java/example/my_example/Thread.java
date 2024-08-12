package example.my_example;

public class Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread");
        }
    }
}

class MyThread extends java.lang.Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("my thread");
        }
    }
}

