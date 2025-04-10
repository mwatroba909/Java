package JavaMarkt;

import junit.framework.TestCase;

public class PromotionCommandsTest extends TestCase {
    
    public void testDiscount300() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 200));
        cart.addProduct(new Product("P002", "Myszka", 50));
        
        Discount300 discount = new Discount300();
        discount.apply(cart);
        
        // Total < 300, so no discount should be applied
        assertEquals(250.0, cart.getTotal(), 0.001);
        
        // Add more products to exceed 300
        cart.addProduct(new Product("P003", "Klawiatura", 100));
        discount.apply(cart);
        
        // Now total > 300, so 5% discount should be applied
        assertEquals(332.5, cart.getTotal(), 0.1);
    }
    
    public void testThirdCheapestFree() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 2500));
        cart.addProduct(new Product("P002", "Myszka", 50));
        cart.addProduct(new Product("P003", "Klawiatura", 150));
        cart.addProduct(new Product("P004", "Kabel HDMI", 30));
        
        ThirdCheapestFreeCommand promotion = new ThirdCheapestFreeCommand();
        promotion.apply(cart);
        
        // The third cheapest item (Klawiatura - 150) should be free
        boolean foundFreeItem = false;
        for (Product p : cart.getProducts()) {
            if (p.isFree() && p.getCode().equals("P003")) {
                foundFreeItem = true;
                break;
            }
        }
        
        assertTrue("Third cheapest item should be free", foundFreeItem);
    }
    
    public void testOnOne30() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 1000));
        cart.addProduct(new Product("P002", "Myszka", 50));
        
        OnOne30 promotion = new OnOne30("P001");
        promotion.apply(cart);
        
        // The P001 product should have 30% discount
        assertEquals(700.0, cart.getProducts()[0].getDiscountPrice(), 0.001);
        assertEquals(50.0, cart.getProducts()[1].getDiscountPrice(), 0.001);
    }
}