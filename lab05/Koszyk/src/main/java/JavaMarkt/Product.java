package JavaMarkt;

public class Product
{
    private String code;
    private String name;
    private double price;
    // private boolean isFree;
    private double discountPrice;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Double getDiscountPrice() { return discountPrice; }

    public void cantBeLowerDiscountPrice() {
        this.discountPrice = Math.max(0.0, discountPrice);
    }

    public void setDiscountPrice(double newPrice) {
        this.discountPrice = newPrice;
    }

    public Boolean isFree() { return discountPrice == 0.0; } 



}
