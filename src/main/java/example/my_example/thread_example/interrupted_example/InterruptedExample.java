package example.my_example.thread_example.interrupted_example;


public class InterruptedExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN START");

        Task task = new Task();
        task.start();

        Thread.sleep(4444); // даём потоку поработать

        task.interrupt(); // прерываем поток

        Thread.sleep(2000); // спит

        synchronized (task) {
            task.notify();
        }

        System.out.println("MAIN END");
    }
}

class Task extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(4443);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 500; i++) {
            if (isInterrupted()) {
                System.out.println("Interrupted");
                return;
            }
            System.out.println("I:" + i);
        }
    }
}
