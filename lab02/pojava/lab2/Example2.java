package lab02.pojava.lab2;

import javax.swing.*;
import java.awt.*;

public class Example2 {
    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame();
		
        JButton button1 = new JButton("Przycisk 1");
        frame.add(button1, BorderLayout.PAGE_START);
                
        JButton button2 = new JButton("Przycisk 2");
        frame.add(button2, BorderLayout.PAGE_END);

        JLabel label = new JLabel("To jest etykieta");
        frame.add(label);
                
        JTextField field = new JTextField("A to pole tekstowe");
        frame.add(field);
                
        frame.setLayout(new FlowLayout());

        frame.setVisible(true);
    }
}
