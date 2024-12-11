package example.my_example.thread_example.synchronizer.exchanger;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Truck implements Runnable {

    private final String departure;
    private final String destination;
    private final String[] parcels;
    private final Exchanger<String> exchanger;

    public Truck(String departure, String destination, String[] parcels, Exchanger<String> exchanger) {
        this.departure = departure;
        this.destination = destination;
        this.parcels = parcels;
        this.exchanger = exchanger;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Truck from " + departure + " to " + destination + " loaded by " +
                parcels[0] + " and " + parcels[1]);
        Thread.sleep(new Random().nextInt(2, 5) * 1000L);
        System.out.println("Truck from " + departure + " to " + destination + " arrive to E");

        parcels[1] = exchanger.exchange(parcels[1]);

        System.out.println("Truck from " + departure + " to " + destination +
                " get parcel for " + destination);

        Thread.sleep(new Random().nextInt(2, 5) * 1000L);
        System.out.println("Truck from " + departure + " to " + destination + " arrive to " +
                destination + " with parcel " + parcels[0] + " and " + parcels[1]);
    }
}







