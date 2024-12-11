package example.my_example.thread_example.synchronizer.collections;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsApp {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        // обычная хэш-карта Map, где ключи и значения - строки.
        // HashMap не потокобезопасен, поэтому не предназначен для
        // одновременного доступа из нескольких потоков без внешней синхронизации.

        Map<String, String> concurentMap = new ConcurrentHashMap<>();
        // конкурентная реализация Map - ConcurrentHashMap
        // эта структура данных безопасна для одновременного использования несколькими потоками
        // без необходимости внешней синхронизации

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        // блокирующая очередь фиксированного размера 10 — ArrayBlockingQueue.
        // потоки, пытающиеся добавить элемент в полную очередь, будут заблокированы, пока не освободится место.
        // потоки, пытающиеся взять элемент из пустой очереди, также будут заблокированы, пока не появится элемент.

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // список CopyOnWriteArrayList.
        // эта реализация делает копию внутреннего массива при каждом изменении, что обеспечивает безопасную итерацию
        // без блокировок в многопоточной среде.
        // подходит для случаев, когда запись происходит нечасто, а чтение — часто.

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        // набор CopyOnWriteArraySet.
        // это, по сути, обертка над CopyOnWriteArrayList для использования в виде Set.
        // также обеспечивает безопасную итерацию без блокировок за счет копирования массива при модификации.
    }
}
















