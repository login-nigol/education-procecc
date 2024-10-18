package example.functionality.promotional_decorator;

public class Decorator {
    public static void main(String[] args) {

        Promo[] promos = new Promo[]{
                new InnerPro1(10),
                new InnerPro2(10)
        };

        Product product = new Product();
        product.price = 100;
        System.out.println(product.price);

        Product item = new ProxyProduct(promos).getProduct(product);
        System.out.println(item.price);
    }
}

// Создается массив промоакций: фиксированная скидка 10 рублей (InnerPro1(10)) и процентная скидка 10% (InnerPro2(10)).
//
//Создается продукт с ценой 100.
//
//Применяются промоакции через класс ProxyProduct.
//
//Выводится начальная цена (100), а затем — цена продукта после применения всех промоакций.