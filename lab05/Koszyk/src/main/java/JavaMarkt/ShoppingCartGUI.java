package JavaMarkt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

public class ShoppingCartGUI extends JFrame {
    private JTable beforeTable;
    private JTable afterTable;
    private JLabel beforeTotalLabel;
    private JLabel afterTotalLabel;
    private JLabel promotionLabel;
    private DefaultTableModel beforeModel;
    private DefaultTableModel afterModel;
    private DecimalFormat df = new DecimalFormat("#0.00");

    public ShoppingCartGUI() {
        setTitle("Koszyk JavaMarkt");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JPanel beforePanel = new JPanel(new BorderLayout());
        beforePanel.setBorder(BorderFactory.createTitledBorder("Koszyk przed promocjami"));
        
        String[] columnNames = {"Kod", "Nazwa", "Cena (zł)"};
        beforeModel = new DefaultTableModel(columnNames, 0);
        beforeTable = new JTable(beforeModel);
        JScrollPane beforeScrollPane = new JScrollPane(beforeTable);
        beforePanel.add(beforeScrollPane, BorderLayout.CENTER);
        
        beforeTotalLabel = new JLabel("Łączna wartość: 0.00 zł");
        beforeTotalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        beforePanel.add(beforeTotalLabel, BorderLayout.SOUTH);
        
        JPanel afterPanel = new JPanel(new BorderLayout());
        afterPanel.setBorder(BorderFactory.createTitledBorder("Koszyk po promocjach"));
        
        afterModel = new DefaultTableModel(columnNames, 0);
        afterTable = new JTable(afterModel);
        JScrollPane afterScrollPane = new JScrollPane(afterTable);
        afterPanel.add(afterScrollPane, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        afterTotalLabel = new JLabel("Łączna wartość po promocji: 0.00 zł");
        afterTotalLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
        promotionLabel = new JLabel("Zastosowana promocja: Brak promocji");
        promotionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
        
        southPanel.add(afterTotalLabel);
        southPanel.add(promotionLabel);
        afterPanel.add(southPanel, BorderLayout.SOUTH);
        
        add(beforePanel);
        add(afterPanel);
    }

    public void displayCart(ShoppingCart cart) {
        beforeModel.setRowCount(0);
        afterModel.setRowCount(0);
        
        for (Product product : cart.getProducts()) {
            beforeModel.addRow(new Object[]{
                product.getCode(),
                product.getName(),
                df.format(product.getPrice())
            });
        }
        beforeTotalLabel.setText("Łączna wartość: " + df.format(cart.getTotal()) + " zł");
        
        PromotionsStrategy strategy = new BestPromotion();
        cart.applyPromotionsWithStrategy(strategy);
        
        for (Product product : cart.getProducts()) {
            afterModel.addRow(new Object[]{
                product.getCode(),
                product.getName(),
                df.format(product.getDiscountPrice())
            });
        }
        afterTotalLabel.setText("Łączna wartość po promocji: " + df.format(cart.getTotal()) + " zł");
        promotionLabel.setText("Zastosowana promocja: " + cart.getAppliedPromotionName());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingCartGUI gui = new ShoppingCartGUI();
            ShoppingCart cart = new ShoppingCart();

            cart.addProduct(new Product("P001", "Laptop", 50));
            cart.addProduct(new Product("P002", "Myszka", 50));
            cart.addProduct(new Product("P003", "Klawiatura", 50));
            cart.addProduct(new Product("P004", "Kabel HDMI", 30));


            cart.addPromotion(new Discount300());
            cart.addPromotion(new ThirdCheapestFreeCommand());
            cart.addPromotion(new OnOne30("P001"));
            
            gui.displayCart(cart);
            gui.setVisible(true);
        });
    }
}