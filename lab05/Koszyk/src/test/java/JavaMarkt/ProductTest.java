package JavaMarkt;

import junit.framework.TestCase;

public class ProductTest extends TestCase {
    
    public void testProductConstructor() {
        Product product = new Product("P001", "Laptop", 2500);
        assertEquals("P001", product.getCode());
        assertEquals("Laptop", product.getName());
        assertEquals(2500.0, product.getPrice(), 0.001);
        assertEquals(2500.0, product.getDiscountPrice(), 0.001);
    }
    
    public void testSetDiscountPrice() {
        Product product = new Product("P002", "Myszka", 50);
        product.setDiscountPrice(40);
        assertEquals(40.0, product.getDiscountPrice(), 0.001);
    }
    
    public void testNegativeDiscountPriceNotAllowed() {
        Product product = new Product("P003", "Klawiatura", 150);
        product.setDiscountPrice(-10);
        assertEquals(0.0, product.getDiscountPrice(), 0.001);
    }
    
    public void testIsFree() {
        Product product = new Product("P004", "Kabel HDMI", 30);
        assertFalse(product.isFree());
        
        product.setDiscountPrice(0);
        assertTrue(product.isFree());
    }
    
    public void testToString() {
        Product product = new Product("P005", "Monitor", 800);
        assertEquals("P005: Monitor - 800.0 zł", product.toString());
    }
}