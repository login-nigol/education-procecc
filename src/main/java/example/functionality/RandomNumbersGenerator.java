package example.functionality;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {

    public static void main(String[] args) {

        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 6) {
            int number = random.nextInt(36) + 1;
            numbers.add(number);
        }
        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }
        System.out.println(result.toString());
    }
}
// Объяснение программы
//Импорт классов: Импортируем классы Random, HashSet и Set. Random используется для генерации случайных чисел,
// а HashSet и Set — для хранения уникальных чисел.
//
//Создание класса и метода: Объявляем класс RandomNumbersGenerator и метод main, который будет точкой входа в программу.
//
//Инициализация Random и Set: Создаем экземпляр класса Random для генерации случайных чисел. Также создаем объект HashSet
// для хранения уникальных чисел.
//
//Генерация случайных чисел: Используем цикл while, который будет продолжаться до тех пор, пока размер множества numbers
// не станет равен 6. Внутри цикла генерируем случайное число в диапазоне от 1 до 36 (включительно) с помощью random.nextInt(36) + 1.
// Метод nextInt(36) возвращает случайное число от 0 до 35, поэтому мы добавляем 1, чтобы получить число в диапазоне от 1 до 36.
//
//Добавление чисел в множество: Добавляем сгенерированное число в numbers. Поскольку HashSet не допускает дублирование,
// множество всегда будет содержать только уникальные числа.
// Итератор: Используем Iterator для обхода множества numbers.
//
//Добавление чисел и запятых: В цикле while добавляем число в StringBuilder и проверяем, есть ли еще элементы. Если есть,
// добавляем запятую и пробел.
//
//Вывод результата: Преобразуем StringBuilder в строку и выводим ее.
//
//Теперь программа будет генерировать 6 уникальных чисел и выводить их через запятую.