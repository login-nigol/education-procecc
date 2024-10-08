package example.my_example.thread_example.priority_threads;

public class PriorityThreads {
    public static void main(String[] args) {

        // Инициализация менеджера потоков для 10 потоков
        ThreadManager threadManager = new ThreadManager(10);

        // Создание потоков и установка приоритетов
        threadManager.createThreads();

        // Запуск потоков
        threadManager.startThreads();

        // Ожидание завершения всех потоков
        threadManager.joinThreads();
    }
}
