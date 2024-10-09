package example.my_example.thread_example.multi_threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Имеется общий счет. Два пользователя раз в 1 сек. кладут 10 $ на этот счет. Реализовать потокобезопасным способом.

public class AccountBalance {

    // Общий счет
    private static int accountBalance = 0;

    // Блокировка для синхронизации
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Создаем два потока для добавления средств
        Thread user1 = new Thread(new DepositTask(), "User 1");
        Thread user2 = new Thread(new DepositTask(), "User 2");

        // Запускаем потоки
        user1.start();
        user2.start();

        // Ожидаем завершения потоков
        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим итоговый баланс
        System.out.println("Итоговый баланс: " + accountBalance + " $");
    }

    // Задача, которую выполняет каждый поток
    static class DepositTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {  // каждый поток кладет деньги 10 раз
                deposit(10);  // кладем 10$
                try {
                    Thread.sleep(1000);  // задержка в 1 сек
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Метод для добавления средств на счет
        private void deposit(int amount) {
            lock.lock();  // захватываем блокировку
            try {
                accountBalance += amount;
                System.out.println(Thread.currentThread().getName() + " добавил 10$. Текущий баланс: " + accountBalance + " $");
            } finally {
                lock.unlock();  // освобождаем блокировку
            }
        }
    }
}
