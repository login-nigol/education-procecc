## Decorator - Декоратор

Этот код представляет собой пример применения паттерна "Декоратор" или "Прокси", где продукт проходит через различные
промоакции, каждая из которых изменяет его цену.

### Результат работы программы:

Начальная цена продукта: 100.

Применение первой промоакции (фиксированная скидка 10): 100 - 10 = 90.

Применение второй промоакции (скидка 10% от 90): 90 - 9 = 81.

Выводится итоговая цена: 81.

Этот код демонстрирует, как можно применять разные промоакции к продукту с помощью прокси, что облегчает расширяемость и
поддержку кода.

### Давайте разберем код по частям:

#### 1. Класс Product:

Это базовый класс, который представляет продукт. У него есть одно поле — price (цена продукта).

#### 2. Интерфейс Promo:

Интерфейс, который описывает промоакцию. Метод apply(int price) должен применить промоакцию к переданной цене и вернуть
новую цену.

#### 3. Классы промоакций: InnerPro1 и InnerPro2:

InnerPro1:

Этот класс представляет промоакцию с фиксированной скидкой (например, 10 рублей). В конструкторе принимается значение
скидки sale, которое затем вычитается из цены в методе apply.

InnerPro2:

Этот класс представляет промоакцию с процентной скидкой. В конструкторе принимается процент скидки (например, 10%).
Метод apply уменьшает цену на указанный процент.

#### 4. Класс ProxyProduct:

Этот класс реализует "прокси" для применения всех промоакций к продукту.

В конструкторе он принимает массив промоакций Promo[] promos.

Метод getProduct создает новый продукт temp, который копирует цену оригинального продукта product.

Далее в цикле по каждой промоакции применяется метод apply, изменяя цену на основе текущей промоакции.

После применения всех промоакций возвращается новый продукт с обновленной ценой.

#### 5. Главный метод main:

Создается массив промоакций: фиксированная скидка 10 рублей (InnerPro1(10)) и процентная скидка 10% (InnerPro2(10)).

Создается продукт с ценой 100.

Применяются промоакции через класс ProxyProduct.

Выводится начальная цена (100), а затем — цена продукта после применения всех промоакций.