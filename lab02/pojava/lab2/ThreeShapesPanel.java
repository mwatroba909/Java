package lab02.pojava.lab2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
// import java.awt.*;

public class ThreeShapesPanel extends JPanel {


    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(50, 50, 150,100);

        g.setColor(Color.green);
        g.fillOval(50, 50, 150, 100);

    }

    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame();
        ThreeShapesPanel panel = new ThreeShapesPanel();

        panel.setBackground(Color.white);
        frame.add(panel);

        frame.setVisible(true);
    }  
}
