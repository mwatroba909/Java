package JavaMarkt;

public class FreeMugPromotion implements PromotionCommands {
    
    private static final String MUG_CODE = "GIFT001";
    private static final String MUG_NAME = "Kubek firmowy";
    private static final double MUG_VALUE = 20.0;
    private static final double THRESHOLD = 200.0;
    
    @Override
    public void apply(ShoppingCart cart) {
        double total = calculateCartTotal(cart);
        
        if (total >= THRESHOLD) {
            boolean mugExists = false;
            for (Product product : cart.getProducts()) {
                if (product.getCode().equals(MUG_CODE)) {
                    product.setDiscountPrice(0.0);
                    mugExists = true;
                    break;
                }
            }
            
            if (!mugExists) {
                Product mug = new Product(MUG_CODE, MUG_NAME, MUG_VALUE);
                mug.setDiscountPrice(0.0);
                cart.addProduct(mug);
            }
        }
    }
    
    private double calculateCartTotal(ShoppingCart cart) {
        double total = 0.0;
        for (Product product : cart.getProducts()) {
            if (!product.getCode().equals(MUG_CODE)) {
                total += product.getPrice();
            }
        }
        return total;
    }
}