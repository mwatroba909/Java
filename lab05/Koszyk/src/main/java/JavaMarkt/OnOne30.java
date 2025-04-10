// package JavaMarkt;

// public class OnOne30 implements PromotionCommands {
//     private String productCode;

//     public OnOne30(String code) {
//         this.productCode = code;
//     }

//     public void apply(Product[] products, int size) {
//         for (int i = 0; i < size; i++) {
//             if (products[i].getCode().equals(productCode)) {
//                 double newPrice = products[i].getDiscountPrice() * 0.7;
//                 products[i].setDiscountPrice(newPrice);
//                 break;
//             }
//         }
//     }

//     public String getName() {
//         return "Kupon 30% na produkt " + productCode;
//     }
// }

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
