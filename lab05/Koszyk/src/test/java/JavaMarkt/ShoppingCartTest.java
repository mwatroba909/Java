package JavaMarkt;

import junit.framework.TestCase;

public class ShoppingCartTest extends TestCase {
    
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 2500));
        
        Product[] products = cart.getProducts();
        assertEquals(1, products.length);
        assertEquals("P001", products[0].getCode());
    }
    
    public void testGetTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 2500));
        cart.addProduct(new Product("P002", "Myszka", 50));
        
        assertEquals(2550.0, cart.getTotal(), 0.001);

        cart.getProducts()[0].setDiscountPrice(2000);
        assertEquals(2050.0, cart.getTotal(), 0.001);
    }
    
    public void testApplyPromotions() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 2500));
        cart.addProduct(new Product("P002", "Myszka", 50));
        cart.addProduct(new Product("P003", "Klawiatura", 150));

        double originalTotal = 2500 + 50 + 150; // 2700.0
        double expectedDiscountedTotal = originalTotal * 0.95; // 2565.0

        cart.addPromotion(new Discount300());
        
        cart.applyPromotionsWithStrategy(new BestPromotion());

        assertEquals(expectedDiscountedTotal, cart.getTotal(), 0.1);
    }
}