package JavaMarkt;

public class BestPromotion implements PromotionsStrategy {
    @Override
    public void applyPromotions(ShoppingCart cart, PromotionCommands[] promotions) {
        // Stosujemy promocje kolejno
        for (PromotionCommands promo : promotions) {
            promo.apply(cart);
        }
        // Przykładowo ustawiamy nazwę promocji na "BestPromotion" jeśli co najmniej jedna promocja została zastosowana
        cart.setAppliedPromotionName(promotions.length > 0 ? "BestPromotion" : "Brak promocji");
    }
}
