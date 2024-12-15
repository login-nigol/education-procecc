package example.my_example.thread_example.producer_consumer;


import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private static int PARCELS_COUNT = 1000;

    private final List<Parcel> parcels;

    public Producer(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    @Override
    public void run() {
        Random random = new Random();
        Faker faker = new Faker();
        for (int i = 0; i < PARCELS_COUNT; i++) {
            int count = random.nextInt(50);
            System.out.println("Generate " + count + " parcels");
            synchronized (parcels) {
                for (int j = 0; j < count; j++) {
                    Parcel parcel = new Parcel(faker.idNumber().valid(),
                            faker.address().fullAddress());

                    parcels.add(parcel);
                    System.out.println("Put parcel with number " + j + ": " + parcel);
                }
            }
            i += count;
        }
    }
}
//    private SharedBuffer sharedBuffer;
//
//    public Producer(SharedBuffer sharedBuffer) {
//        this.sharedBuffer = sharedBuffer;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        while (true) {
//
//            synchronized (sharedBuffer) {
//                for (int i = 0; i < 100; i++) {
//                    int number = random.nextInt(100);
//                    sharedBuffer.put(number);
//                    System.out.println("put " + number);
//                }
//                sharedBuffer.notifyAll();
//                System.out.println();
//                try {
//                    sharedBuffer.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            sleep(1000);
//        }
//
//    }
//
//    private static void sleep(int time) {
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

