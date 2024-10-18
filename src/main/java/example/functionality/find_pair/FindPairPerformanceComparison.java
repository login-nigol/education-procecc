package example.functionality.find_pair;

import java.util.*;

// Оценка производительности алгоритмов поиска флажками
public class FindPairPerformanceComparison {

    public static void main(String[] args) {
        int[] numbersArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Инициализация массива цифр
        List<Integer> numbersList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // Инициализация списка цифр
        int targetSum = 18; // Целевая сумма

        // Замер времени для метода с указателями
        long startTimePointers = System.nanoTime();
        findPairWithPointers(numbersArray, targetSum);
        long endTimePointers = System.nanoTime();
        long durationPointers = endTimePointers - startTimePointers;

        // Замер времени для метода со стримами
        long startTimeStreams = System.nanoTime();
        findPairWithStreams(numbersList, targetSum);
        long endTimeStreams = System.nanoTime();
        long durationStreams = endTimeStreams - startTimeStreams;

        // Замер времени для метода с хэш-таблицей
        long startTimeHashMap = System.nanoTime();
        findPairWithHashMap(numbersArray, targetSum);
        long endTimeHashMap = System.nanoTime();
        long durationHashMap = endTimeHashMap - startTimeHashMap;

        // Вывод результатов
        System.out.println("Время выполнения метода с указателями: " + durationPointers + " нс");
        System.out.println("Время выполнения метода со стримами: " + durationStreams + " нс");
        System.out.println("Время выполнения метода с хэш-таблицей: " + durationHashMap + " нс");
    }

    // Метод с указателями
    private static void findPairWithPointers(int[] numbers, int targetSum) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == targetSum) {
                System.out.println("Пара чисел (указатели): " + numbers[left] + " и " + numbers[right]);
                return;
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Пара чисел не найдена (указатели)");
    }

    // Метод со стримами и лямбда выражениями (списковое включение)
    private static void findPairWithStreams(List<Integer> numbers, int targetSum) {
        Optional<int[]> result = numbers.stream()
                .flatMap(i -> numbers.stream().map(j -> new int[]{i, j})) // Создаем поток пар чисел
                .filter(pair -> pair[0] + pair[1] == targetSum) // Фильтруем пары, сумма которых равна целевой
                .findFirst(); // Находим первую подходящую пару
        // numbers.stream() создает стрим из списка numbers.
        //flatMap(i -> numbers.stream().map(j -> new int[]{i, j})) создает поток всех возможных пар чисел из списка.
        // Для каждого элемента i в numbers создается новый стрим, который мапится на пары [i, j], где j — каждый элемент из списка.
        //filter(pair -> pair[0] + pair[1] == targetSum) фильтрует пары, сумма которых равна целевой сумме.

        if (result.isPresent()) { // Если result.isPresent() возвращает true, выводим найденную пару.
            int[] pair = result.get();
            System.out.println("Пара чисел (стримы): " + pair[0] + " и " + pair[1]);
        } else {
            System.out.println("Пара чисел не найдена (стримы)");
        }
    }

    // Метод с хэш-таблицей
    private static void findPairWithHashMap(int[] numbers, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>(); // Инициализация HashMap для хранения чисел и их индексов

        for (int i = 0; i < numbers.length; i++) { // Перебираем каждый элемент в массиве
            int complement = targetSum - numbers[i]; // Вычисляем комплемент для текущего числа
            // Используем цикл for для перебора каждого элемента массива. Для каждого элемента вычисляем комплемент complement,
            // который равен targetSum - numbers[i].
            if (map.containsKey(complement)) { // Проверяем, содержится ли комплемент в HashMap
            // Если содержится, значит мы нашли пару чисел, сумма которых равна targetSum.
                System.out.println("Пара чисел (хэш-таблица): " + complement + " и " + numbers[i]);
                return;
            }
            map.put(numbers[i], i); // Если комплемент не найден, добавляем текущее число в HashMap
        } // Если комплемент не найден в хэш-таблице, добавляем текущее число и его индекс в map.
        System.out.println("Пара чисел не найдена (хэш-таблица)");
    }
}