package JavaMarkt;

import java.util.*;

public class ProductUtils {
    
    public static Product findCheapest(Product[] products) {
        return Arrays.stream(products).min(Comparator.comparingDouble(Product::getDiscountPrice)).orElse(null);
    }

    public static Product findExpensive(Product[] products) {
        return Arrays.stream(products).max(Comparator.comparingDouble(Product::getDiscountPrice)).orElse(null);
    }

    public static Product[] findCheapestN(Product[] products, int n) {
        return Arrays.stream(products).sorted(Comparator.comparingDouble(Product::getDiscountPrice)).limit(n).toArray(Product[]::new);
    }

    public static Product[] findExpensiveN(Product[] products, int n) {
        return Arrays.stream(products).sorted(Comparator.comparingDouble(Product::getDiscountPrice)).limit(n).toArray(Product[]::new);
    }

    public static void sortByPrice(Product[] products) {
        Arrays.sort(products, Comparator.comparingDouble(Product::getDiscountPrice));
    }

    public static void sortByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getName));
    }

    public static double calculateTotal(Product[] products) {
        return Arrays.stream(products).mapToDouble(Product::getDiscountPrice).sum();
    }
}
