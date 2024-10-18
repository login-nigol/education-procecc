package example.logic_games.SnakeFill;

import java.util.ArrayList;
import java.util.List;

public class SnakeFillVariants {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Ввод размеров массива
//        System.out.print("Введите количество строк: ");
//        int rows = scanner.nextInt();
//        System.out.print("Введите количество столбцов: ");
//        int cols = scanner.nextInt();

        int rows = 10;
        int cols = 20;

        // Сценарии для каждого из направлений (вниз-вправо, вниз-влево, вверх-вправо, вверх-влево)
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // Списки для хранения координат начальных точек
        List<String> fullFillCoords = new ArrayList<>();
        List<String> cornerCoords = new ArrayList<>();
        List<String> startPointCoords = new ArrayList<>();

        for (int startX = 0; startX < rows; startX++) {
            for (int startY = 0; startY < cols; startY++) {
                for (int[] direction : directions) {
                    int dx = direction[0];
                    int dy = direction[1];

                    // Инициализация массива и начальных координат
                    char[][] array = new char[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            array[i][j] = '.';
                        }
                    }

                    int x = startX;
                    int y = startY;
                    array[x][y] = '0';

                    boolean isFull = false;
                    while (true) {
                        int newX = x + dx;
                        int newY = y + dy;

                        // Проверка на границы массива и изменение направления
                        if (newX < 0 || newX >= rows) {
                            dx = -dx;
                            newX = x + dx;
                        }
                        if (newY < 0 || newY >= cols) {
                            dy = -dy;
                            newY = y + dy;
                        }

                        // Проверка на заполнение всей матрицы
                        isFull = true;
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < cols; j++) {
                                if (array[i][j] == '.') {
                                    isFull = false;
                                    break;
                                }
                            }
                            if (!isFull) break;
                        }
                        if (isFull) {
                            fullFillCoords.add("(" + startX + ", " + startY + ")");
                            break;
                        }

                        // Проверка на угол или возврат в начальную точку
                        if ((newX == startX && newY == startY)) {
                            startPointCoords.add("(" + startX + ", " + startY + ")");
                            break;
                        }
                        if ((newX == 0 && newY == 0) || (newX == rows - 1 && newY == 0) ||
                                (newX == 0 && newY == cols - 1) || (newX == rows - 1 && newY == cols - 1)) {
                            cornerCoords.add("(" + startX + ", " + startY + ")");
                            break;
                        }

                        array[newX][newY] = 'X';
                        x = newX;
                        y = newY;
                    }
                }
            }
        }

        System.out.println("Координаты начальных точек для полного заполнения массива: " + fullFillCoords);
        System.out.println("Координаты начальных точек для попадания в угол: " + cornerCoords);
        System.out.println("Координаты начальных точек для возврата в начальную точку: " + startPointCoords);
    }
}