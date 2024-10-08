package example.programms.junit_test.geometric;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GeometricService {

    public static List<Square> findPerfectSquares(List<Geometric> geometries) {

        List<Square> squares = new ArrayList<>();

        for (int i = 0; i < geometries.size(); i++) {
            if (geometries.get(i) instanceof Square) {
                Square square = (Square) geometries.get(i);
                squares.add(square);
            }
        }
        return squares;
    }

    public static List<Circle> findCirclesInMinMaxRadiusRange(List<Geometric> geometries, double minRadius,
                                                                                            double maxRadius) {
        List<Circle> circles = new ArrayList<>();

        for (Geometric geometric : geometries) {
            if (geometric instanceof Circle) {
                Circle circle = (Circle) geometric;
                circles.add(circle);
            }
        }
        return circles;
    }

    public static List<Line> findLinesLongerThanLength(List<Geometric> geometries, double length) {

        List<Line> lines = new ArrayList<>();


        return null;
    }

    //Метод возвращает список треугольников (класса Triangle), у которых радиус вписанного круга больше среднего
    // радиуса всех кругов в коллекции.
    public static List<Triangle> findTrianglesWithLargerInscribedCircleThanAverage(List<Geometric> geometries) {
        return null;
    }

    public static long countByType(List<Geometric> geometries, Class<? extends Geometric> type) {
        return 0;
    }

    //Метод возвращает список всех квадратов и кругов, у которых стороны (для квадратов) или радиус (для кругов)
    // находятся в заданном диапазоне.
    public static List<Geometric> findSquaresAndCirclesInRange(List<Geometric> geometries, double minValue,
                                                               double maxValue) {
        return null;
    }
}
