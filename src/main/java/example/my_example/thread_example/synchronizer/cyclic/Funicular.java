package example.my_example.thread_example.synchronizer.cyclic;

public class Funicular implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("!! Took people and going to the top");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
