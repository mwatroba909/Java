package JavaMarkt;

public class Product {
    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getDiscountPrice() {
        return discountPrice;
    }
    
    public void setDiscountPrice(double newPrice) {
        this.discountPrice = Math.max(0.0, newPrice);
    }
    
    public boolean isFree() {
        return discountPrice == 0.0;
    }
    
    @Override
    public String toString() {
        return code + ": " + name + " - " + discountPrice + " zł";
    }
}
