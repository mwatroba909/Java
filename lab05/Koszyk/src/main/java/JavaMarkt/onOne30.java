package JavaMarkt;

public class onOne30 implements PromotionCommands {
    private String productCode;

    public onOne30(String code) {
        this.productCode = code;
    }

    public void apply(Product[] products, int size) {
        for (int i = 0; i < size; i++) {
            if (products[i].getCode().equals(productCode)) {
                double newPrice = products[i].getDiscountPrice() * 0.7;
                products[i].setDiscountPrice(newPrice);
                break;
            }
        }
    }

    public String getName() {
        return "Kupon 30% na produkt " + productCode;
    }
}