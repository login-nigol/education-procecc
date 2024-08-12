package example.programms;

public class IPValidation {

    public static void main(String[] args) {
        String testAddress1 = "192.168.0.1";
        String testAddress2 = "05.255.255.242";
        String testAddress3 = "256.100.50.0";
        String testAddress4 = "192.168.0";

        System.out.println(validateIPAddress(testAddress1)); // true
        System.out.println(validateIPAddress(testAddress2)); // false
        System.out.println(validateIPAddress(testAddress3)); // false
        System.out.println(validateIPAddress(testAddress4)); // false
    }

    public static boolean validateIPAddress(String ip) {

//        // Проверяем, что IP-адрес не начинается с '0'
//        if (ip.startsWith("0")) {
//            return false;
//        }

        // Разделяем строку по точкам
        String[] parts = ip.split("\\.");

        // Проверяем, что количество частей равно 4
        if (parts.length != 4) {
            return false;
        }

        // Проверяем каждую часть
        for (String part : parts) {
            // Проверяем, что часть не пустая
            if (part.isEmpty()) {
                return false;
            }

            // Проверяем, что часть состоит только из цифр
            if (!part.matches("\\d+")) {
                return false;
            }

            // Преобразуем часть в целое число
            int num = Integer.parseInt(part);

            // Проверяем, что число находится в диапазоне от 0 до 255
            if (num < 0 || num > 255) {
                return false;
            }

            // Проверяем ведущие нули
            // Преобразуем число обратно в строку и сравниваем с оригиналом
            // Это позволит нам обнаружить строки вроде "05", "005" и т.д.
            if (!part.equals(String.valueOf(num))) {
                return false;
            }
        }

        // Если все проверки пройдены, возвращаем true
        return true;
    }
}
