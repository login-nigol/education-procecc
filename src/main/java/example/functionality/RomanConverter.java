package example.functionality;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RomanConverter {

    // Метод для конвертации одного числа в римскую цифру
    public static String intToRoman(int num) { // Метод intToRoman: конвертирует одно число в римскую цифру,
                                               // используя LinkedHashMap для хранения пар "символ-регистрация".
        Map<String, Integer> romanMap = new LinkedHashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);

        StringBuilder roman = new StringBuilder();
        // Создаем объект StringBuilder, который используется для накопления и эффективного построения результирующей строки.
        // Этот объект позволяет добавлять символы к строке без создания новых строк при каждой операции, что делает его более
        // эффективным, чем использование оператора + для конкатенации строк.

        for (Map.Entry<String, Integer> entry : romanMap.entrySet()) { // Запускаем цикл for-each, который проходит через
            // все пары ключ-значение (элементы) из romanMap. romanMap.entrySet() возвращает набор (set) всех записей (entry)
            // в Map, где каждая запись представляет собой пару "ключ-значение".
            while (num >= entry.getValue()) { // Внутри цикла for-each запускаем цикл while, который продолжается,
                // пока текущее значение num больше или равно значению текущей записи из romanMap (entry.getValue()).
                // Это условие проверяет, можем ли мы вычесть значение текущей римской цифры из num.
                num -= entry.getValue(); // Вычитаем значение текущей римской цифры из num. Это уменьшает num
                                            // на соответствующее значение текущей римской цифры.
                roman.append(entry.getKey()); // Добавляем римскую цифру (ключ текущей записи) к объекту StringBuilder.
                // Это действие повторяется столько раз, сколько раз значение текущей римской цифры может быть вычтено из num.
            }
        }

        return roman.toString(); // После завершения всех циклов возвращаем результирующую строку, представляющую число
        // в римской записи. Метод toString() вызывается для преобразования объекта StringBuilder в строку.
    }

    // Метод для конвертации списка чисел
    public static List<String> convertListToRoman(List<Integer> numbers) { // Метод convertListToRoman:
        // принимает список целых чисел, конвертирует каждое из них в римскую цифру с помощью intToRoman, и возвращает список строк.
        List<String> romanNumerals = new ArrayList<>();
        for (int number : numbers) {
            romanNumerals.add(intToRoman(number));
        }
        return romanNumerals;
    }

    public static void main(String[] args) {
        // Пример использования
        List<Integer> numbers = List.of(1994, 58, 2023, 7);
        List<String> romanNumerals = convertListToRoman(numbers);

        // Вывод результата
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Число " + numbers.get(i) + " в римской записи: " + romanNumerals.get(i));
        }
    }
}
