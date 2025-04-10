package JavaMarkt;

public class Discount300 implements PromotionCommands {
    @Override
    public void apply(ShoppingCart cart) {
        if (cart.getTotal() > 300) {
            for (Product p : cart.getProducts()) {
                double oldPrice = p.getDiscountPrice();
                p.setDiscountPrice(oldPrice * 0.95);
            }
        }
    }
}
