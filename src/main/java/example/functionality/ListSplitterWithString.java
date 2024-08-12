package example.functionality;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListSplitterWithString {

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        // Заполнение списка для примера
        for (int i = 1; i <= 100; i++) {
            originalList.add(i);
        }

        int chunkSize = 10; // Размер каждой части

        List<List<Integer>> partitionedList = splitList(originalList, chunkSize);

        // Вывод результата
        partitionedList.forEach(System.out::println);
    }

    public static List<List<Integer>> splitList(List<Integer> list, int chunkSize) {
        // Преобразование списка в строку
        String listString = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // Использование Stream.iterate для генерации индексов начала частей строки
        int numberOfChunks = (int) Math.ceil((double) listString.length() / chunkSize);

        List<String> stringChunks = IntStream.iterate(0, n -> n + chunkSize)
                .limit(numberOfChunks)
                .mapToObj(start -> listString.substring(start, Math.min(start + chunkSize, listString.length())))
                .collect(Collectors.toList());

        // Преобразование строковых частей обратно в списки чисел
        return stringChunks.stream()
                .map(chunk -> List.of(chunk.split(",")))
                .map(chunkList -> chunkList.stream()
                        .filter(str -> !str.isEmpty()) // фильтрация пустых строк
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
