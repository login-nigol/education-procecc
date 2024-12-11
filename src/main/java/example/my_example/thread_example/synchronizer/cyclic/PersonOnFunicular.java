package example.my_example.thread_example.synchronizer.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class PersonOnFunicular implements Runnable {

    private final String name;
    private final CyclicBarrier cyclicBarrier;

    public PersonOnFunicular(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    // Переопределяем метод run() из интерфейса Runnable
    @Override
    public void run() {
        // выводим сообщение о том, что поток (с именем name) ожидает на платформе
        System.out.println("-> " + name + " wait on platform");
        try {
            // дожидаемся, пока все участники барьера соберутся (сработает cyclicBarrier)
            // поток будет заблокирован на этой строке, пока остальные не вызовут await()
            cyclicBarrier.await();

            // когда барьер снят (все потоки дошли до точки сбора),
            // выводим сообщение о том, что человек теперь "на вершине"
            System.out.println("<- " + name + " on the top");
        } catch (InterruptedException e) {
            // если поток был прерван во время ожидания у барьера, бросаем RuntimeException
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            // если барьер был "сломлен" (например, один из потоков вышел с ошибкой),
            // также выбрасываем RuntimeException
            throw new RuntimeException(e);
        }
    }
}
