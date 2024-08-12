package example.functionality;

import java.util.List;


public class ConvertNumToStr { // Преобразовать список чисел в список строк.

    public static void main(String[] args) {

        // Исходный список чисел
        List<Integer> numberList = List.of(1, 2, 3, 4, 5);

        // Вывод результата
        System.out.println(numberList);
        List<String> str = stringList(numberList);
        System.out.println(stringList(numberList));
        System.out.println(numberList.get(3).getClass().getSimpleName()); // проверка стринги
    }

    // Преобразование списка чисел в список строк с использованием Stream API
    public static List<String> stringList(List<Integer> numberList){
        return numberList.stream()
                .map(String::valueOf)
                .toList();
//        Stream API: numberList.stream() создаёт поток (stream) из списка чисел.
//        Метод map: map(String::valueOf) преобразует каждое число в строку.
//        Метод toList: toList(); собирает результаты преобразования в новый список.
    }
}
