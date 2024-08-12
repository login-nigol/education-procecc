package example.programms.task_management_systems;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil { // Класс DateTimeFormatterUtil: Содержит метод для форматирования даты и времени
    // в строку по заданному формату.

    public static String formatDateTime(ZonedDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
