package example.my_example.thread_example;

import java.util.Random;

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

//            System.out.println();
        }
    }
}
// Класс для потока "Курица"
class Chicken extends Thread {
    @Override
    public void run() {
        Random rand = new Random();
        try {
            // Задержка случайной продолжительности
            Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курица");
    }
}

// Класс для потока "Яйцо"
class Egg extends Thread {
    @Override
    public void run() {
        Random rand = new Random();
        try {
            // Задержка случайной продолжительности
            Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Яйцо");
    }
}