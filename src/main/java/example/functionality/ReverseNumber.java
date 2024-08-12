package example.functionality;

public class ReverseNumber {

    public static void main(String[] args) {
        // Дано число
        int number = 123;

        // Шаг 1: String.valueOf(number) преобразует целое число number в строку
        String numberStr = String.valueOf(number);

        // Шаг 2: Разворачиваем строку с помощью StringBuilder. new StringBuilder(numberStr).reverse().toString()
        // создает объект StringBuilder, инициализирует его строкой numberStr, вызывает метод reverse(), который
        // разворачивает строку, и метод toString(), который возвращает развернутую строку.
        String reversedStr = new StringBuilder(numberStr).reverse().toString();

        // Шаг 3: Integer.parseInt(reversedStr) преобразует развернутую строку обратно в целое число.
        int reversedNumber = Integer.parseInt(reversedStr);

        // Вывод результата
        System.out.println("Исходное число: " + number);
        System.out.println("Развернутое число: " + reversedNumber);
    }
}

// Для инверсии отрицательного числа нужно учитывать знак. В данном случае логика будет схожа с инверсией положительного числа,
// но нам потребуется обработать знак отдельно.
//
//Вот шаги решения:
//
//Проверим, является ли число отрицательным.
//Если число отрицательное, удалим знак, развернем оставшуюся часть и добавим знак обратно.
//Если число положительное, развернем его как обычно.

// public class ReverseNumber {
//    public static void main(String[] args) {
//        // Дано число
//        int number = -123;
//
//        // Определяем, является ли число отрицательным
//        boolean isNegative = number < 0;
//
//        // Преобразуем число в строку без знака
//        String numberStr = String.valueOf(Math.abs(number));
//
//        // Разворачиваем строку с помощью StringBuilder
//        String reversedStr = new StringBuilder(numberStr).reverse().toString();
//
//        // Преобразуем развернутую строку обратно в число
//        int reversedNumber = Integer.parseInt(reversedStr);
//
//        // Восстанавливаем знак, если число было отрицательным
//        if (isNegative) {
//            reversedNumber = -reversedNumber;
//        }
//
//        // Вывод результата
//        System.out.println("Исходное число: " + number);
//        System.out.println("Развернутое число: " + reversedNumber);
//    }
//}
// boolean isNegative = number < 0; определяет, является ли число отрицательным.
//String numberStr = String.valueOf(Math.abs(number)); преобразует абсолютное значение числа (без знака) в строку.
//new StringBuilder(numberStr).reverse().toString(); разворачивает строку.
//int reversedNumber = Integer.parseInt(reversedStr); преобразует развернутую строку обратно в целое число.
//if (isNegative) { reversedNumber = -reversedNumber; } восстанавливает знак, если число было отрицательным.

