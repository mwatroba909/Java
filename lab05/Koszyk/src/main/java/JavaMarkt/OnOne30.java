package JavaMarkt;

public class OnOne30 implements PromotionCommands {
    private String productCode;
    
    public OnOne30(String productCode) {
        this.productCode = productCode;
    }
    
    @Override
    public void apply(ShoppingCart cart) {
        for (Product p : cart.getProducts()) {
            if (p.getCode().equals(productCode)) {
                double price = p.getDiscountPrice();
                p.setDiscountPrice(price * 0.70);
            }
        }
    }
}
