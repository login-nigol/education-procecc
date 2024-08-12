package example.logicgames.SnakeFill;

public class SnakeFillSumVariants {

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

        int fullFillCount = 0;
        int cornerCount = 0;
        int startPointCount = 0;

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
                            fullFillCount++;
                            break;
                        }

                        // Проверка на угол или возврат в начальную точку
                        if ((newX == startX && newY == startY)) {
                            startPointCount++;
                            break;
                        }
                        if ((newX == 0 && newY == 0) || (newX == rows - 1 && newY == 0) ||
                                (newX == 0 && newY == cols - 1) || (newX == rows - 1 && newY == cols - 1)) {
                            cornerCount++;
                            break;
                        }

                        array[newX][newY] = 'X';
                        x = newX;
                        y = newY;
                    }
                }
            }
        }

        System.out.println("Количество начальных точек для полного заполнения массива: " + fullFillCount);
        System.out.println("Количество начальных точек для попадания в угол: " + cornerCount);
        System.out.println("Количество начальных точек для возврата в начальную точку: " + startPointCount);
    }
}
