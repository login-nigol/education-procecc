package example.my_example.thread_example.producer_consumer;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class SharedBuffer {

    private Queue<Integer> queueNumbers;

    public SharedBuffer() {
        queueNumbers = new LinkedList<>();
    }

    public void put(int number) {
        queueNumbers.add(number);
    }

    public int get() {
        return queueNumbers.poll();
    }

    public boolean isEmptyQueue() {
        return queueNumbers.isEmpty();
    }
}
