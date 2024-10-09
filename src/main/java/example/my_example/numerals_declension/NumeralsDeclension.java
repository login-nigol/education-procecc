package example.my_example.numerals_declension;

public class NumeralsDeclension {

    public static String getDeclension(int number, String[] forms) {

        number = Math.abs(number) % 100;
        int lastDigit = number % 10;

        if (number > 10 && number < 20) {
            return forms[2];
        }
        if (lastDigit > 1 && lastDigit < 5) {
            return forms[1];
        }
        if (lastDigit == 1) {
            return forms[0];
        }
        return forms[2];
    }
}

