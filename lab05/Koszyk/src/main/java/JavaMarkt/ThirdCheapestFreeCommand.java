package JavaMarkt;

import java.util.Arrays;
import java.util.Comparator;

public class ThirdCheapestFreeCommand implements PromotionCommands {
    @Override
    public void apply(ShoppingCart cart) {
        Product[] items = cart.getProducts();
        if (items.length < 3) return;
        
        // Tworzymy kopię tablicy i sortujemy wg ceny (discountPrice)
        Product[] sorted = Arrays.copyOf(items, items.length);
        Arrays.sort(sorted, Comparator.comparingDouble(Product::getDiscountPrice));
        
        // Ustawiamy trzeci najtańszy produkt jako gratis
        sorted[2].setDiscountPrice(0.0);
    }
}
