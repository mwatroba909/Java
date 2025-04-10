// package JavaMarkt;

// import java.util.*;

// public class BestPromotion implements PromotionsStrategy {
//     public void applyPromotions(ShoppingCart cart, PromotionCommands[] promotions) {
//         double bestTotal = Double.MAX_VALUE;
//         List<PromotionCommands> bestCombo = null;

//         for (List<PromotionCommands> perm : getAllPermutations(promotions)) {
//             ShoppingCart copy = cloneCart(cart);

//             for (PromotionCommands p : perm) {
//                 Product[] products = copy.getProducts();
//                 p.apply(products, products.length);
//             }

//             double total = copy.getTotal();
//             if (total < bestTotal) {
//                 bestTotal = total;
//                 bestCombo = perm;
//             }
//         }

//         // Stosujemy najlepszą kolejność promocji do prawdziwego koszyka
//         if (bestCombo != null) {
//             for (PromotionCommands p : bestCombo) {
//                 Product[] products = cart.getProducts();
//                 p.apply(products, products.length);
//             }
//         }
//     }
    
//     private ShoppingCart cloneCart(ShoppingCart original) {
//         ShoppingCart copy = new ShoppingCart();
//         for (Product p : original.getProducts()) {
//             copy.addProduct(new Product(p.getCode(), p.getName(), p.getPrice()));
//         }
//         return copy;
//     }

//     private List<List<PromotionCommands>> getAllPermutations(PromotionCommands[] arr) {
//         List<List<PromotionCommands>> result = new ArrayList<>();
//         permute(arr, 0, result);
//         return result;
//     }

//     private void permute(PromotionCommands[] arr, int start, List<List<PromotionCommands>> result) {
//         if (start == arr.length) {
//             result.add(new ArrayList<>(Arrays.asList(arr.clone())));
//             return;
//         }

//         for (int i = start; i < arr.length; i++) {
//             swap(arr, start, i);
//             permute(arr, start + 1, result);
//             swap(arr, start, i);
//         }
//     }

//     private void swap(PromotionCommands[] arr, int i, int j) {
//         PromotionCommands tmp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = tmp;
//     }
// }

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
