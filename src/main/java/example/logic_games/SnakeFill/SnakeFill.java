package example.logic_games.SnakeFill;

public class SnakeFill {

    public static void main(String[] args) {
        int size = 10;
        char[][] grid = new char[size][size];

        // Заполнить массив пробелами
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '.';
            }
        }
        // Начальные координаты и направление (движемся по диагонали вниз-вправо)
        int x = 8;
        int y = 1;
        int dx = 1;
        int dy = 1;

        // Начальная точка
        int startX = x;
        int startY = y;
        grid[startX][startY] = '0';

        while (true) {
            grid[x][y] = 'X';

            int newX = x + dx;
            int newY = y + dy;

            // Проверка на границы массива и изменение направления
            if (newX < 0 || newX >= size) {
                dx = -dx;
                newX = x + dx;
            }
            if (newY < 0 || newY >= size) {
                dy = -dy;
                newY = y + dy;
            }
            // Проверка на угол или возврат в начальную точку
            if ((newX == startX && newY == startY) || (newX == 0 && newY == 0) || (newX == size - 1 && newY == 0) ||
                    (newX == 0 && newY == size - 1) || (newX == size - 1 && newY == size - 1)) {
                grid[newX][newY] = 'E';
                break;
            }
            x = newX;
            y = newY;
        }
        // Печать массива
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}