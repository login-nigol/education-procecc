package example.programms.junit_test.geometric;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeometricFactory {
    public static List<Geometric> createGeometricShapes() {
        List<Geometric> shapes = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            shapes.add(new Line(randomDouble()));
        }


        for (int i = 0; i < 20; i++) {
            shapes.add(new Circle(randomDouble()));
        }

        for (int i = 0; i < 30; i++) {
            shapes.add(generateValidTriangle());
        }

        // Генерация квадратов
        for (int i = 0; i < 50; i++) {
            double side = randomDouble();
            shapes.add(new Square(side, side));
        }

        return shapes;
    }

    private static Triangle generateValidTriangle() {
        double a, b, c;

        do {
            a = randomDouble();
            b = randomDouble();
            c = randomDouble();
        } while (!isValidTriangle(a, b, c));

        return new Triangle(a, b, c);
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private static double randomDouble() {
        return Math.random() * 100;
    }
}
