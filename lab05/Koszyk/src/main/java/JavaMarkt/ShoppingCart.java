package JavaMarkt;

import java.util.Arrays;
import java.util.Comparator;

public class ShoppingCart {
    private Product[] products = new Product[100];
    private int size = 0;
    private PromotionCommands[] promotions = new PromotionCommands[10];
    private int promoSize = 0;
    private Comparator<Product> sortStrategy;

    public void addProduct(Product product) {
        if (size < products.length ) {
            products[size++] = product;
            sortProducts();
        }
    }

    public void addPromotion(PromotionCommands promo ) {
        if ( promoSize < promotions.length ) {
            promotions[promoSize++] = promo;
            sortProducts();
        }
    }

    public void setSortStrategy(Comparator<Product> strategy) {
        this.sortStrategy = strategy;
        sortProducts();
    }

    public void sortProducts() {
        if (sortStrategy != null ) {
            Arrays.sort(products, 0, size, sortStrategy);
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getDiscountPrice();
        }
        return total;
    }    


    public Product[] getProducts() {
        return Arrays.copyOf(products, size);
    }

    public void printCart() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
        System.out.println("SUMA: " + getTotal() + " zł");
    }
}
