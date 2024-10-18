package example.functionality.find_pair;

public class FindPair {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Инициализация отсортированного списка цифр
        int targetSum = 18; // Целевая сумма
        // Здесь мы создаем массив numbers, который содержит отсортированные числа от 0 до 10, и переменную targetSum,
        // равной 18.
        int left = 0; // Указатель 1
        int right = numbers.length - 1; // Указатель 2
        // Устанавливаем два указателя: left указывает на начало массива, а right на его конец.
        while (left < right) { // Пока указатели не пересеклись, пока не стали равны.
            int sum = numbers[left] + numbers[right]; // Вычисляем сумму чисел на позициях указателей
            // Цикл while выполняется, пока указатели не пересекутся. На каждой итерации мы вычисляем сумму чисел,
            // на которые указывают left и right.
            if (sum == targetSum) { // Если сумма равна целевой
                System.out.println("Required pair: " + numbers[left] + " and " + numbers[right]);
                return; // Завершаем выполнение программы
            } else if (sum < targetSum) { // Если сумма меньше целевой
                left++; // Сдвигаем левый указатель вправо
            } else { // Если сумма больше целевой
                right++; // Сдвигаем правый указатель влево
                // Если сумма равна targetSum, выводим найденную пару и завершаем программу.
                //Если сумма меньше targetSum, сдвигаем левый указатель вправо, чтобы увеличить сумму.
                //Если сумма больше targetSum, сдвигаем правый указатель влево, чтобы уменьшить сумму.
            }
        }
        System.out.println("There is no pair of numbers whose sum is equal to: " + targetSum);
        // Если цикл завершился и пара не найдена, выводим сообщение "Пара чисел не найдена".
        //
        //
        //
        //
        //
        //
        //
        //Этот АЛГОРИТМ имеет временную сложность O(n), где n — количество элементов в массиве,
        // что делает его эффективным для данной задачи.
    }
}

// public class TwoSum {
//    public static void main(String[] args) {
//        int[] array = {1, 2, 4, 5, 6, 7, 8, 10, 12, 14}; // Пример отсортированного массива
//        int targetSum = 15;
//        int[] result = findTwoNumbers(array, targetSum);
//
//        if (result != null) {
//            System.out.println("Пара чисел: " + result[0] + " и " + result[1]);
//        } else {
//            System.out.println("Нет пары чисел, сумма которых равна " + targetSum);
//        }
//    }
//
//    public static int[] findTwoNumbers(int[] array, int targetSum) {
//        int left = 0;
//        int right = array.length - 1;
//
//        while (left < right) {
//            int sum = array[left] + array[right];
//
//            if (sum == targetSum) {
//                return new int[]{array[left], array[right]};
//            } else if (sum < targetSum) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return null; // Если пара не найдена
//    }
//}