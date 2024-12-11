package example.my_example.thread_example.synchronizer.cyclic;

import java.util.concurrent.CyclicBarrier;

// объявляем публичный класс CyclicBarrierApp,
// который будет точкой входа в программу (содержит метод main).
public class CyclicBarrierApp {
    public static void main(String[] args) throws Exception {
        // создаём объект CyclicBarrier на 2 участника.
        // вторым параметром передаём объект Runnable (new Funicular()),
        // который будет выполнен, когда оба участника достигнут барьера.
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Funicular());

        // создаем массив строк person
        String[] person = {"Roman", "Elena", "Ivan", "Egor", "Anna", "Leo", "Bob", "Vika"};
        for (int i = 0; i < person.length; i++) {
            // для каждого имени создаем новый поток, которому передаем
            // объект PersonOnFunicular (реализующий Runnable) с заданным именем
            // и ссылкой на тот же cyclicBarrier.
            new Thread(new PersonOnFunicular(person[i], cyclicBarrier)).start();
            Thread.sleep(1000);
        }
    }
}
