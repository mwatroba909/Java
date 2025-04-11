package JavaMarkt;

import java.util.Arrays;
import java.util.Comparator;

public class ThirdCheapestFreeCommand implements PromotionCommands {
    @Override
    public void apply(ShoppingCart cart) {
        Product[] items = cart.getProducts();
        if (items.length < 3) return;
        
        Product[] sorted = Arrays.copyOf(items, items.length);
        Arrays.sort(sorted, Comparator.comparingDouble(Product::getDiscountPrice));
        
        int numberOfGroups = items.length / 3;
        
        for (int i = 0; i < numberOfGroups; i++) {
            int startIndex = i * 3;
            
            Product cheapest = sorted[startIndex];
            for (int j = startIndex + 1; j < startIndex + 3 && j < sorted.length; j++) {
                if (sorted[j].getDiscountPrice() < cheapest.getDiscountPrice()) {
                    cheapest = sorted[j];
                }
            }
            
            cheapest.setDiscountPrice(0.0);
        }
    }
}