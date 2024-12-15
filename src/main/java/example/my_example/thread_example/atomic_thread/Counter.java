package example.my_example.thread_example.atomic_thread;

import lombok.SneakyThrows;

public class Counter implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            CounterApp.counter.getAndIncrement();
            System.out.println("" + CounterApp.counter.get() + "-" + Thread.currentThread().getName());
            Thread.sleep(1);
        }
    }
}
