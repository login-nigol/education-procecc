package example.functionality;

import java.util.Arrays;
import java.util.List;

public class Stringing {
    public static void main(String[] args) {

            List<String> strings = Arrays.asList("Java", "Stream", "API");

            // Соединяем строки через пробел
            String result = strings.stream()
                    .reduce((a, b) -> a + " " + b)
                    .orElse("");

            System.out.println("Результат: " + result);
        }
}
