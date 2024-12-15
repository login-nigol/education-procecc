package example.my_example.thread_example.pool_thread;

public class Handler implements Runnable {

    @Override
    public void run() {
        System.out.println("Handler " + Thread.currentThread().getName());
        System.out.println("Доставка пиццы");
    }
}
