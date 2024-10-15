package example.my_example.thread_example.co_cy_se_tread.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PersonOnFunicular implements Runnable {

    private String name;
    private CyclicBarrier cyclicBarrier;

    public PersonOnFunicular(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("->" + name + " wait on platform");
        try {
            cyclicBarrier.await();
            System.out.println("!!" + name + " on the top");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
