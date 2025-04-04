package JavaMarkt;

import java.util.Arrays;
import java.util.Comparator;

public class ThirdCheapestFreeCommand implements PromotionCommands {
    public void apply(Product[] products, int size) {
        if (size >= 3) {
            int freebies = size / 3;

            Product[] copy = Arrays.copyOf(products, size);
            Arrays.sort(copy, Comparator.comparingDouble(Product::getDiscountPrice));

            for (int i = 0; i < freebies; i++) {
                copy[i].setDiscountPrice(0.0);
            }
        }
    }

    public String getName() {
        return "Co trzeci produkt najtańszy gratis";
    }
}
