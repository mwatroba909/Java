package JavaMarkt;

public class BestPromotion implements PromotionsStrategy {
    @Override
    public void applyPromotions(ShoppingCart cart, PromotionCommands[] promotions) {
        if (promotions.length == 0) {
            cart.setAppliedPromotionName("Brak promocji");
            return;
        }

        // Try each promotion and find the one that provides the best discount
        double originalTotal = calculateTotal(cart);
        double bestSavings = 0;
        String bestPromoName = "Brak promocji";

        for (PromotionCommands promo : promotions) {
            // Create a copy of the cart to test this promotion individually
            ShoppingCart tempCart = createCartCopy(cart);
            
            // Apply just this promotion
            promo.apply(tempCart);
            
            // Calculate savings
            double savings = originalTotal - calculateTotal(tempCart);
            
            if (savings > bestSavings) {
                bestSavings = savings;
                // Determine promotion name based on class
                bestPromoName = getPromotionName(promo);
            }
        }
        
        // Apply the best promotion to the real cart
        for (PromotionCommands promo : promotions) {
            if (getPromotionName(promo).equals(bestPromoName)) {
                promo.apply(cart);
                break;
            }
        }

        cart.setAppliedPromotionName(bestPromoName);
    }
    
    private String getPromotionName(PromotionCommands promo) {
        if (promo instanceof Discount300) {
            return "Zniżka 5% przy zakupach powyżej 300 zł";
        } else if (promo instanceof ThirdCheapestFreeCommand) {
            return "Trzeci najtańszy produkt za darmo";
        } else if (promo instanceof OnOne30) {
            return "30% zniżki na wybrany produkt";
        } else if (promo instanceof FreeMugPromotion) {
            return "Darmowy kubek firmowy przy zakupach powyżej 200 zł";
        } else {
            return promo.getClass().getSimpleName();
        }
    }
    
    private double calculateTotal(ShoppingCart cart) {
        double total = 0;
        for (Product product : cart.getProducts()) {
            total += product.getDiscountPrice();
        }
        return total;
    }
    
    private ShoppingCart createCartCopy(ShoppingCart original) {
        ShoppingCart copy = new ShoppingCart();
        for (Product product : original.getProducts()) {
            Product productCopy = new Product(product.getCode(), product.getName(), product.getPrice());
            productCopy.setDiscountPrice(product.getDiscountPrice());
            copy.addProduct(productCopy);
        }
        return copy;
    }
}