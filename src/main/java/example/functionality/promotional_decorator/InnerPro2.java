package example.functionality.promotional_decorator;

public class InnerPro2 implements Promo{

    double sale;

    public InnerPro2(double sale) {
        this.sale = sale;
    }

    @Override
    public int apply(int price){
        return price = (int) (price - price * this.sale / 100);
    }
}

// Этот класс представляет промоакцию с процентной скидкой. В конструкторе принимается процент скидки (например, 10%).
//Метод apply уменьшает цену на указанный процент.