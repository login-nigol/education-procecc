## Задача

"Приоритетные потоки": Напишите программу, которая создает 10 потоков. Каждый поток должен вывести свой номер
1000 раз. Установите потокам приоритеты в порядке их создания (от MIN_PRIORITY до MAX_PRIORITY). Запустите программу
несколько раз и проанализируйте, влияет ли приоритет на порядок выполнения потоков.

## Пояснение:

#### Класс PriorityThreads:

Этот класс запускает программу. В нем создается объект ThreadManager, который управляет созданием и выполнением потоков.

#### Класс MyThread:

Этот класс отвечает за выполнение задачи потока. Каждый поток выводит свой номер (переданный в конструкторе) 1000 раз.

#### Класс ThreadManager:

Здесь сосредоточена логика по созданию, запуску и управлению потоками.
Метод createThreads() создает потоки и назначает каждому поток номер и приоритет.
Метод startThreads() запускает все потоки.
Метод joinThreads() ожидает завершения всех потоков с помощью join().


#### Как работает программа:

1. Создание потоков: В методе createThreads() создаются потоки и устанавливаются приоритеты от 1 (MIN_PRIORITY) до 10 (
MAX_PRIORITY).

2. Запуск потоков: В методе startThreads() все потоки запускаются. Каждый поток начинает выводить свой номер 1000 раз.

3. Ожидание завершения: После запуска потоков метод joinThreads() блокирует выполнение основного потока, пока все дочерние
потоки не завершат свою работу.

4. Анализ приоритетов: Так как потоки имеют разные приоритеты, ты можешь заметить, что потоки с более высоким приоритетом
могут завершать выполнение быстрее, хотя это не гарантируется.