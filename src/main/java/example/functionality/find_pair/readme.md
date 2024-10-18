## FindPairPerformanceComparison

### Оценка производительности алгоритмов поиска флажками

Когда вы запускаете приведенный код, вы получите время выполнения каждого метода. Вот как можно интерпретировать результаты:

#### Метод с указателями:

Этот метод имеет временную сложность O(n), где n — количество элементов в массиве.
Обычно он будет самым быстрым, так как требуется один проход по массиву, и время поиска пары чисел в
отсортированном массиве очень эффективно.

#### Метод со стримами:

Этот метод имеет временную сложность O(n^2) из-за двойного вложенного потока (flatMap и map).
В результате может быть заметно медленнее, особенно на больших входных данных, поскольку он требует генерации
всех возможных пар и проверки их суммы.

#### Метод с хэш-таблицей:

Этот метод также имеет временную сложность O(n), где n — количество элементов в массиве.
Обычно он будет немного медленнее, чем метод с указателями, из-за дополнительных затрат на работу с хэш-таблицей,
но все равно будет значительно быстрее, чем метод со стримами.

#### Заключение:

Метод с указателями обычно является самым эффективным для этой задачи, особенно когда у вас есть отсортированный массив.

Метод с хэш-таблицей также эффективен, но требует дополнительной памяти.

Метод со стримами, хотя и стильный и функциональный, может быть медленнее из-за своей сложности и накладных расходов.