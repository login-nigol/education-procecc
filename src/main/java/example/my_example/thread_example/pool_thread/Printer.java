package example.my_example.thread_example.pool_thread;

public class Printer implements Runnable {

    private int number;

    public Printer() {
    }

    public Printer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Printer number " + number + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
