package example.my_example.thread_example.synchronizer.exchanger;

import java.util.concurrent.Exchanger;

// синхронизатор
public class ExchangerApp {
    /*

    A ---\ /--- C       1: A -> C, A -> D ( A -> D, B -> D ) // A -> D
          E                                                   пересекаются
    B ---/ \--- D       2: B -> C, B -> D ( B -> C, A -> C ) // B -> C

     */
    public static void main(String[] args) throws InterruptedException {
        Exchanger <String> exchanger = new Exchanger<>();
        String[] cargo1 = {"A->D", "A->C"};
        String[] cargo2 = {"B->C", "D->D"};

        new Thread(new Truck("A", "D", cargo1, exchanger)).start();

        Thread.sleep(2000);

        new Thread(new Truck("B", "C", cargo2, exchanger)).start();
    }
}
