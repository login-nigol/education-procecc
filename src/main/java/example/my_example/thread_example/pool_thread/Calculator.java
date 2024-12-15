package example.my_example.thread_example.pool_thread;

import java.util.concurrent.Callable;

public class Calculator implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Calculator " + Thread.currentThread().getName());
        Thread.sleep(5000);
        return "Привет из будущего!!!";
    }
}
