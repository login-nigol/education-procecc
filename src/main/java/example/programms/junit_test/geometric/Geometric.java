package example.programms.junit_test.geometric;

import lombok.*;

public abstract class Geometric {
}

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
class Square extends Geometric {
    private double sideAB;
    private double sideBC;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
class Triangle extends Geometric {
    private double sideAB;
    private double sideBC;
    private double sideCA;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
class Circle extends Geometric {
    private double radius;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
class Line extends Geometric {
    private double lengthL;
}
