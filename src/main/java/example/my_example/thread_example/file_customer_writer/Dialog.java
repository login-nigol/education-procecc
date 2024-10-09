package example.my_example.thread_example.file_customer_writer;

import java.util.Queue;
import java.util.Scanner;

public class Dialog implements Runnable {

    private Queue<String> strings;

    public Dialog(Queue<String> strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите город или exit для выхода");
            String city = scanner.next();
            if ("exit".equals(city)) {
                break;
            }
            synchronized (strings) {
                strings.add(city);
            }
        }
    }
}
