package example.my_example.thread_example.file_customer_writer;


import java.util.LinkedList;
import java.util.Queue;

public class ExampleApp {
    public static void main(String[] args) {

        Queue<String> strings = new LinkedList<>();

        Monitor monitor = new Monitor(strings, new FileCustomerWriter());
        Dialog dialog = new Dialog(strings);

        Thread threadMonitor = new Thread(monitor);
        Thread threadDialog = new Thread(dialog);

        threadMonitor.setDaemon(true);
        threadMonitor.start();

        threadDialog.start();
    }
}
