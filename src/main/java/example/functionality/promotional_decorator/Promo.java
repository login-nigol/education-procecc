package example.functionality.promotional_decorator;

public interface Promo {
    int apply(int price);
}

// Интерфейс, который описывает промоакцию. Метод apply(int price) должен применить промоакцию к переданной цене и
// вернуть новую цену.