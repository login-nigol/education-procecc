package example.my_example.thread_example.producer_consumer;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Parcel> parcels = new LinkedList<Parcel>();

        new Thread(new Producer(parcels)).start();
//        new Thread(new Consumer(parcels)).start();
    }
}


//        SharedBuffer sharedBuffer = new SharedBuffer();
//
//        Thread producerThread = new Thread(new Producer(sharedBuffer));
//        Thread consumerThread1 = new Thread(new Consumer(sharedBuffer));
//        Thread consumerThread2 = new Thread(new Consumer(sharedBuffer));
//        Thread consumerThread3 = new Thread(new Consumer(sharedBuffer));
//
////        Consumer consumer = new Consumer(sharedBuffer);
////        Producer producer = new Producer(sharedBuffer);
////
////        Thread threadConsumer1 = new Thread(consumer);
////        Thread threadConsumer2 = new Thread(consumer);
////        Thread threadConsumer3 = new Thread(consumer);
//
////        Thread threadProducer = new Thread(producer);
//
//        producerThread.start();
//        consumerThread1.start();
//        consumerThread2.start();
//        consumerThread3.start();
//    }
