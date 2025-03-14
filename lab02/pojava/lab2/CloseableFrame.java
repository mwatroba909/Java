package lab02.pojava.lab2;

import javax.swing.JFrame;
import java.awt.*;

public class CloseableFrame extends JFrame {

    public CloseableFrame() throws HeadlessException {
        super();
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public CloseableFrame(GraphicsConfiguration gc) {
        super(gc);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public CloseableFrame(String title) throws HeadlessException {
        super(title);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public CloseableFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame();
        frame.setVisible(true);
    }
}