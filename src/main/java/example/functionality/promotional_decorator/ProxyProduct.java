package example.functionality.promotional_decorator;

public class ProxyProduct {

    Promo[] promos;

    public ProxyProduct(Promo[] promos) {
        this.promos = promos;
    }

    Product getProduct(Product product) {
        Product temp = new Product();
        temp.price = product.price;

        for (Promo item : promos) {
            temp.price = item.apply(temp.price);
        }
        return temp;
    }
}

// Этот класс реализует "прокси" для применения всех промоакций к продукту.
//
//В конструкторе он принимает массив промоакций Promo[] promos.
//
//Метод getProduct создает новый продукт temp, который копирует цену оригинального продукта product.
//
//Далее в цикле по каждой промоакции применяется метод apply, изменяя цену на основе текущей промоакции.
//
//После применения всех промоакций возвращается новый продукт с обновленной ценой.