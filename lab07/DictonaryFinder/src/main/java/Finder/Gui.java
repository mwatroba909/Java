package Finder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    private JTextPane textPane;
    private JButton loadButton;
    private JButton replaceButton;
    
    public Gui() {
        setTitle("Dictionary Finder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new Font("Arial", Font.PLAIN, 14));
        
        loadButton = new JButton("Wczytaj plik");
        replaceButton = new JButton("Zamień litery");
        
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFile();
            }
        });
        
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceText();
            }
        });
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(replaceButton);
        
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textPane), BorderLayout.CENTER);
    }
    
    private void loadFile() {
        ReadFile.read(null);
        textPane.setText(ReadFile.content);
    }
    
    private void replaceText() {
        ReadFile.replace(null);
        textPane.setText(ReadFile.content);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gui().setVisible(true);
        });
    }
}