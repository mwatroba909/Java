// package JavaMarkt;

// public class Main {
//     public static void main(String[] args) {
//         ShoppingCart cart = new ShoppingCart();
        
//         // Dodaj produkty do koszyka
//         cart.addProduct(new Product("P001", "Laptop", 2500));
//         cart.addProduct(new Product("P002", "Myszka", 50));
//         cart.addProduct(new Product("P003", "Klawiatura", 150));
//         cart.addProduct(new Product("P004", "Kabel HDMI", 30));

//         // Utwórz tablicę komend promocji
//         PromotionCommands[] promotions = {
//             new Discount300(),
//             new ThirdCheapestFreeCommand(),
//             new OnOne30("P001"),
//         };

//         // Wyświetl koszyk przed promocjami
//         System.out.println("Koszyk przed promocjami:");
//         printCartDetails(cart);
        
//         // Zastosuj promocje przy użyciu strategii BestPromotion
//         PromotionsStrategy strategy = new BestPromotion();
//         strategy.applyPromotions(cart, promotions);
        
//         // Wyświetl koszyk po promocjach
//         System.out.println("\nKoszyk po promocjach:");
//         printCartDetailsAfterPromotions(cart);
//     }
    
//     private static void printCartDetails(ShoppingCart cart) {
//         System.out.println("Produkty:");
//         for (Product product : cart.getProducts()) {
//             // Przed promocjami pokazujemy pierwotną cenę
//             System.out.printf("- %s (%s): %.2f zł\n", 
//                 product.getName(), product.getCode(), product.getPrice());
//         }
//         System.out.printf("Łączna wartość: %.2f zł\n", cart.getTotal());
//     }

//     private static void printCartDetailsAfterPromotions(ShoppingCart cart) {
//         System.out.println("Produkty po promocji:");
//         for (Product product : cart.getProducts()) {
//             // Po promocjach wypisujemy cenę po uwzględnieniu rabatu (discountPrice)
//             System.out.printf("- %s (%s): %.2f zł\n", 
//                 product.getName(), product.getCode(), product.getDiscountPrice());
//         }
//         System.out.printf("Łączna wartość po promocji: %.2f zł\n", cart.getTotal());
//         // Jeżeli w koszyku nie ustawiono nazwy promocji, wyświetlamy "Brak promocji"
//         String promoName = cart.getAppliedPromotionName();
//         System.out.println("Zastosowana promocja: " + (promoName == null ? "Brak promocji" : promoName));
//     }
// }

package JavaMarkt;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        // Dodaj produkty do koszyka
        cart.addProduct(new Product("P001", "Laptop", 2500));
        cart.addProduct(new Product("P002", "Myszka", 50));
        cart.addProduct(new Product("P003", "Klawiatura", 150));
        cart.addProduct(new Product("P004", "Kabel HDMI", 30));

        // Utwórz promocje i dodaj je do koszyka
        PromotionCommands[] promotions = {
            new Discount300(),
            new ThirdCheapestFreeCommand(),
            new OnOne30("P001")
        };

        // Możemy dodać promocje bezpośrednio do koszyka (jeśli implementacja tego wymaga)
        for (PromotionCommands promo : promotions) {
            cart.addPromotion(promo);
        }

        // Wyświetl koszyk przed promocjami
        System.out.println("Koszyk przed promocjami:");
        printCartDetails(cart);
        
        // Zastosuj promocje przy użyciu strategii BestPromotion
        PromotionsStrategy strategy = new BestPromotion();
        cart.applyPromotionsWithStrategy(strategy);
        
        // Wyświetl koszyk po promocjach
        System.out.println("\nKoszyk po promocjach:");
        printCartDetailsAfterPromotions(cart);
    }
    
    private static void printCartDetails(ShoppingCart cart) {
        System.out.println("Produkty:");
        for (Product product : cart.getProducts()) {
            System.out.printf("- %s (%s): %.2f zł\n", 
                product.getName(), product.getCode(), product.getPrice());
        }
        System.out.printf("Łączna wartość: %.2f zł\n", cart.getTotal());
    }

    private static void printCartDetailsAfterPromotions(ShoppingCart cart) {
        System.out.println("Produkty po promocji:");
        for (Product product : cart.getProducts()) {
            System.out.printf("- %s (%s): %.2f zł\n", 
                product.getName(), product.getCode(), product.getDiscountPrice());
        }
        System.out.printf("Łączna wartość po promocji: %.2f zł\n", cart.getTotal());
        System.out.println("Zastosowana promocja: " + cart.getAppliedPromotionName());
    }
}
