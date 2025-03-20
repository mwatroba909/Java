package lab02.pojava.lab2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.*;

public class ThreeShapesPanel extends JPanel {
    private final Color rectColor;
    private final Color ovalColor;
    private final Color squareColor;

    public ThreeShapesPanel() {
        Random rand = new Random();
        this.rectColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        this.ovalColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        this.squareColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(rectColor);
        g.fillRect(50, 50, 150, 100);

        g.setColor(ovalColor);
        g.fillOval(250, 50, 150, 100);

        g.setColor(squareColor);
        g.fillRect(450, 50, 100, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CloseableFrame frame = new CloseableFrame();
            frame.setLayout(new GridLayout(1, 2));

            JPanel controlPanel = new JPanel();
            controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
            
            JButton button1 = new JButton("Przycisk 1");
            JButton button2 = new JButton("Przycisk 2");
            JLabel label = new JLabel("Etykieta");
            JTextField textField = new JTextField("Pole tekstowe");
            
            controlPanel.add(button1);
            controlPanel.add(button2);
            controlPanel.add(label);
            controlPanel.add(textField);
            
            ThreeShapesPanel shapesPanel = new ThreeShapesPanel();
            
            frame.add(controlPanel);
            frame.add(shapesPanel);
            frame.setVisible(true);

            frame.setSize(1500, 500);
        });
    } 
}
