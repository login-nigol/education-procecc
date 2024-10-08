package example.my_example.thread_example.chicken_or_egg;

public class ChickenOrEgg {

    public static void main(String[] args) throws InterruptedException {
        // Запускаем эксперимент несколько раз для наблюдения
        for (int i = 0; i < 5; i++) {
            System.out.println("Эксперимент " + (i + 1) + ":");

            // Создаем объекты потоков
            Thread chicken = new Chicken();
            Thread egg = new Egg();

            // Стартуем потоки
            chicken.start();
            egg.start();

            // Ждем завершения потоков
            chicken.join();
            egg.join();

            System.out.println();
        }
    }
}

