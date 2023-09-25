package seminars.first.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ShopTest {

    public static void main(String[] args) {
//        1. Напишите тесты, чтобы проверить, что магазин хранит верный список
//        продуктов(правильное количество продуктов, верное содержимое корзины).
//        2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
//        3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).

        List<Product> products = new ArrayList<>();
        Product water = new Product(50, "Borjomi");
        products.add(water);
        Product grape = new Product(300, "Grape");
        products.add(grape);
        Product cheese = new Product(280, "Parmesan");
        products.add(cheese);

        Shop shop = new Shop();
        shop.setProducts(products);

        assertThat(shop.getProducts()).isNotEmpty().hasSize(3).contains(water, grape, cheese);

        for (Product product : shop.getProducts()) {
            if (!product.equals(shop.getMostExpensiveProduct())) {
                assertThat(product.getCost()).isLessThanOrEqualTo(shop.getMostExpensiveProduct().getCost());
            }
        }

        List<Product> sortedList = shop.sortProductsByPrice();

        for (int i = 1; i < sortedList.size(); i++) {
            assertTrue(sortedList.get(i).getCost() >= sortedList.get(i - 1).getCost());
        }
    }
}