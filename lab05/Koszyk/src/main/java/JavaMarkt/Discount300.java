package JavaMarkt;

import java.util.Arrays;

public class Discount300 implements PromotionCommands {
    public void apply(Product[] products, int size) {
        double total = Arrays.stream(products, 0, size)
                             .mapToDouble(Product::getDiscountPrice)
                             .sum();
        if (total > 300) {
            for (int i = 0; i < size; i++) {
                double newPrice = products[i].getDiscountPrice() * 0.95;
                products[i].setDiscountPrice(newPrice);
            }
        }
    }

    public String getName() {
        return "5% zniżki powyżej 300 zł";
    }
}