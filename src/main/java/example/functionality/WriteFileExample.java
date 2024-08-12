package example.functionality;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFileExample {
    public static void main(String[] args) {
        String fileName = "output.txt";
        String content = "Это пример записи в файл.\nВторая строка.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Файл успешно записан.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}

