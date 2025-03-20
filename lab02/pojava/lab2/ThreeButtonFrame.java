package lab02.pojava.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeButtonFrame extends JFrame {
    
    public ThreeButtonFrame() {
        this("Trzy przyciski");
    }
    
    public ThreeButtonFrame(String title) {
        super(title);
        
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton exitButton = new JButton("Zamknij");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JButton changeTitleButton = new JButton("Zmień tytuł");
        changeTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTitle("Nowy tytuł - " + System.currentTimeMillis());
            }
        });
        
        JButton changeColorButton = new JButton("Zmień kolor");
        changeColorButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Color randomColor = new Color(
                    (int)(Math.random() * 256), 
                    (int)(Math.random() * 256), 
                    (int)(Math.random() * 256)
                );
                buttonPanel.setBackground(randomColor);
            }
        });

        buttonPanel.add(exitButton);
        buttonPanel.add(changeTitleButton);
        buttonPanel.add(changeColorButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ThreeButtonFrame frame = new ThreeButtonFrame();
                frame.setVisible(true);
            }
        });
    }
}