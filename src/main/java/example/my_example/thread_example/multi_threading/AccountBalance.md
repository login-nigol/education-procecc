## Пояснение:

accountBalance — общий счет, который обновляют оба потока.

lock — объект блокировки типа ReentrantLock, используемый для синхронизации доступа к общему счету.

Метод deposit(int amount) — добавляет указанное количество средств на счет. Блокировка lock используется для
предотвращения состояния гонки: один поток захватывает блокировку перед изменением общего ресурса, а затем освобождает
ее в блоке finally.

Класс DepositTask — это задача, которую выполняет каждый поток. В нем имитируется операция добавления 10$ с задержкой в
1 секунду.

user1.join() и user2.join() — заставляют главный поток дождаться завершения обоих потоков перед выводом итогового
баланса.

Этот пример гарантирует, что оба потока корректно обновляют общий счет без конфликтов благодаря использованию механизма
блокировки.