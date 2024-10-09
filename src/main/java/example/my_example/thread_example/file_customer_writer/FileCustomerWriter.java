package example.my_example.thread_example.file_customer_writer;

import java.io.FileWriter;
import java.util.List;

public class FileCustomerWriter {

    public void create(String fileName, List<String> stringList) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (String s : stringList) {
                fileWriter.write(s + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
