package example.functionality.promotional_decorator;

public class InnerPro1 implements Promo{

    int sale;

    public InnerPro1(int sale) {
        this.sale = sale;
    }

    @Override
    public int apply(int price){
        return price -= sale;
    }
}

// Этот класс представляет промоакцию с фиксированной скидкой (например, 10 рублей). В конструкторе принимается значение
//скидки sale, которое затем вычитается из цены в методе apply.