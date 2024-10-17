package example.functionality.read_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {

    public static void main(String[] args) {
        String fileName = "src/main/java/example/functionality/read_file/readme.txt";
//        String fileName = "C:\\Users\\user\\Desktop\\text.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
