package example.logicgames;

public class Handshakes { // сколько раз поздароваются

    public static void main(String[] args) {
        int people = 17;
        int handshakes = calculateHandshakes(people);
        System.out.println("Количество рукопожатий: " + handshakes);
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
