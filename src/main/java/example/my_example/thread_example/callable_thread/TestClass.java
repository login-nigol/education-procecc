package example.my_example.thread_example.callable_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestClass {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        OddClass oddClass = new OddClass();
        EvenClass evenClass = new EvenClass();

        Thread oddThread = new Thread(oddClass);
        Thread evenThread = new Thread(evenClass);

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();

        System.out.println(oddClass.oddList);
        System.out.println(evenClass.evenList);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> evenTask = () -> {
            int evenResult = 0;
            for (Integer num : evenClass.evenList) {
                evenResult += num;
            }
            TimeUnit.SECONDS.sleep(3);
            return evenResult;
        };

        Callable<Integer> oddTask = () -> {
            int oddResult = 0;
            for (Integer num : oddClass.oddList) {
                oddResult += num;
            }
            TimeUnit.SECONDS.sleep(1);
            return oddResult;
        };

        Future<Integer> evenFuture = executorService.submit(evenTask);
        Future<Integer> oddFuture = executorService.submit(oddTask);

        System.out.println("Result = " + (evenFuture.get() + oddFuture.get()));
    }
}

class OddClass implements Runnable {

    List<Integer> oddList = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            oddList.add(i);
        }
    }
}

class EvenClass implements Runnable {

    List<Integer> evenList = new ArrayList<Integer>();

    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            evenList.add(i);
        }
    }
}