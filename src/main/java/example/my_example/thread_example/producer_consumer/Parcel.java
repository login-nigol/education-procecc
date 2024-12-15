package example.my_example.thread_example.producer_consumer;

import lombok.ToString;

@ToString
public class Parcel {

    private String trackNumber;

    private String address;

    public Parcel(String trackNumber, String address) {
        this.trackNumber = trackNumber;
        this.address = address;
    }
}
