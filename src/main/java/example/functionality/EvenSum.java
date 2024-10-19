package example.functionality;

import java.util.Arrays;
import java.util.List;

public class EvenSum { // нахождение суммы чётных чисел
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Примеры промежуточных операций
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0) // фильтрация четных чисел
                .mapToInt(n -> n * 2)    // умножение каждого числа на 2
                .sum();                  // суммирование

        System.out.println("Сумма удвоенных четных чисел: " + sum);
    }
}
