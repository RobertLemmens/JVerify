package codebulb.frames;


import javax.swing.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class MainFrame extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public MainFrame() {
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setTitle("JVerify Beta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MainPaneel());
        setVisible(true);
    }
}
