package example.my_example.thread_example.file_customer_writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Monitor implements Runnable {

    private Queue<String> strings;
    private FileCustomerWriter fileCustomerWriter;
    private boolean isRunning;


    public Monitor(Queue<String> strings, FileCustomerWriter fileCustomerWriter) {
        this.strings = strings;
        this.fileCustomerWriter = fileCustomerWriter;
        this.isRunning = true;
    }

    @Override
    public void run() {
        int counter = 1;
        while (true) {
            sleep();
            if (strings.size() >= 10) {
                List<String> words = new ArrayList<>();
                synchronized (strings) {
                    while (!strings.isEmpty()) {
                        words.add(strings.poll());
                    }
                }
                fileCustomerWriter.create("File" + counter++, words);
            }
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
