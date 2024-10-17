package example.logicgames.SnakeFill;

public class SnakeFillV2 {

    public static void main(String[] args) {
        // V:2.0
        // Заполнил массив точками ('.').
        // Начальная точка будет инициализирована нулем "S", а конечная "E".
        // Если змейка возвращается в начальную точку, в угол или сетка полностью заполнена завершает работу.
        // Добавил сообщения при достижении угла, возвращении в начальную точку и при заполнении всей сетки.

//        Scanner scanner = new Scanner(System.in);
//
//        // Ввод размеров массива
//        System.out.print("Введите количество строк: ");
//        int rows = scanner.nextInt();
//        System.out.print("Введите количество столбцов: ");
//        int cols = scanner.nextInt();

        int rows = 10;
        int cols = 20;

        char[][] grid = new char[rows][cols];

        // Заполнить массив точками
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '.';
            }
        }

        // начальные координаты и направление (движемся по диагонали вниз-вправо)
        int x = 6, y = 13;
        int dx = 1, dy = 1;

        // начальная точка
        int startX = x, startY = y;
        grid[x][y] = 'S';

        while (true) { // направление движения, могут быть -1, 0, или 1
            int newX = x + dx; // предполагаемые новые координаты
            int newY = y + dy;

            // проверка на границы сетки и изменение направления
            if (newX < 0 || newX >= rows) {
                dx = -dx; // изменяется на противоположное (умножается на -1)
                newX = x + dx; // пересчитываются новые координаты
            }
            if (newY < 0 || newY >= cols) {
                dy = -dy;
                newY = y + dy;
            }

            // Проверка на заполнение всей матрицы
            boolean isFull = true;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '.') {
                        isFull = false;
                        break;
                    }
                }
                if (!isFull) break;
            }
            if (isFull) {
                System.out.println("Массив полностью заполнен.");
                break;
            }

            // Проверка на угол или возврат в начальную точку
            if ((newX == startX && newY == startY)) {
                System.out.println("Вернулись в начальную точку.");
                break;
            }
            if ((newX == 0 && newY == 0) || (newX == rows - 1 && newY == 0) ||
                    (newX == 0 && newY == cols - 1) || (newX == rows - 1 && newY == cols - 1)) {
                System.out.println("Достигли угла.");
                grid[newX][newY] = 'E';
                break;
            }

            grid[newX][newY] = 'X';
            x = newX;
            y = newY;
        }

        // Печать массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}