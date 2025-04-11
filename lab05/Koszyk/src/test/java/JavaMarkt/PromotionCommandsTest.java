package JavaMarkt;

import junit.framework.TestCase;

public class PromotionCommandsTest extends TestCase {
    
    public void testDiscount300() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("P001", "Laptop", 200));
        cart.addProduct(new Product("P002", "Myszka", 50));
        
        Discount300 discount = new Discount300();
        discount.apply(cart);
        
        assertEquals(250.0, cart.getTotal(), 0.001);
        
        cart.addProduct(new Product("P003", "Klawiatura", 100));
        discount.apply(cart);

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
        
        assertEquals(700.0, cart.getProducts()[0].getDiscountPrice(), 0.001);
        assertEquals(50.0, cart.getProducts()[1].getDiscountPrice(), 0.001);
    }
    
    public void testFreeMugPromotion() {
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(new Product("P001", "Mouse", 50));
        cart1.addProduct(new Product("P002", "Keyboard", 100));
        
        FreeMugPromotion promotion = new FreeMugPromotion();
        promotion.apply(cart1);

        boolean foundMug = false;
        for (Product p : cart1.getProducts()) {
            if (p.getCode().equals("GIFT001")) {
                foundMug = true;
                break;
            }
        }
        assertFalse("Mug should not be added when total < 200", foundMug);

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addProduct(new Product("P001", "Mouse", 50));
        cart2.addProduct(new Product("P002", "Keyboard", 150));
        
        promotion.apply(cart2);

        boolean foundFreeMug = false;
        for (Product p : cart2.getProducts()) {
            if (p.getCode().equals("GIFT001")) {
                foundFreeMug = true;
                assertEquals("Mug should be free", 0.0, p.getDiscountPrice(), 0.001);
                break;
            }
        }
        assertTrue("Free mug should be added when total >= 200", foundFreeMug);

        ShoppingCart cart3 = new ShoppingCart();
        cart3.addProduct(new Product("P001", "Mouse", 50));
        cart3.addProduct(new Product("P002", "Keyboard", 150));
        cart3.addProduct(new Product("GIFT001", "Kubek firmowy", 20));
        
        promotion.apply(cart3);

        int mugCount = 0;
        for (Product p : cart3.getProducts()) {
            if (p.getCode().equals("GIFT001")) {
                mugCount++;
                assertEquals("Existing mug should be free", 0.0, p.getDiscountPrice(), 0.001);
            }
        }
        assertEquals("Should be exactly one mug in cart", 1, mugCount);
    }
}