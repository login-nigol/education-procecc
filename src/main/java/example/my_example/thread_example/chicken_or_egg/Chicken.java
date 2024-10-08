package example.my_example.thread_example.chicken_or_egg;

import java.util.Random;

// Класс для потока "Курица"
class Chicken extends Thread {
    @Override
    public void run() {
        Random delayDurations = new Random();
        try {
            // Задержка случайной продолжительности
            Thread.sleep(delayDurations.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курица");
    }
}
