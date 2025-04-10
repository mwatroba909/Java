// package JavaMarkt;

// import java.util.Arrays;
// import java.util.Comparator;

// public class ThirdCheapestFreeCommand implements PromotionCommands {
//     public void apply(Product[] products, int size) {
//         if (size >= 3) {
//             int freebies = size / 3;

//             Product[] copy = Arrays.copyOf(products, size);
//             Arrays.sort(copy, Comparator.comparingDouble(Product::getDiscountPrice));

//             for (int i = 0; i < freebies; i++) {
//                 copy[i].setDiscountPrice(0.0);
//             }
//         }
//     }

//     public String getName() {
//         return "Co trzeci produkt najtańszy gratis";
//     }
// }

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
