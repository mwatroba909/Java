package JavaMarkt;

public interface PromotionsStrategy {
    void applyPromotions(ShoppingCart cart, PromotionCommands[] promotions);
}
