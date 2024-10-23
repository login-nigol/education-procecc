package example.functionality.numerals_declension;

import static example.functionality.numerals_declension.NumeralsDeclension.getDeclension;

public class Main {
    public static void main(String[] args) {
        String[] hourForms = {"час", "часа", "часов"};
        String[] minuteForms = {"минута", "минуты", "минут"};

        System.out.println(3 + " " + getDeclension(3, hourForms));    // 3 часа
        System.out.println(14 + " " + getDeclension(14, hourForms));  // 14 часов
        System.out.println(21 + " " + getDeclension(21, minuteForms)); // 21 минута
    }
}
