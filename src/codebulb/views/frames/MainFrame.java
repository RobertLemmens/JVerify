package codebulb.views.frames;

import codebulb.views.panels.MainPanel;

import javax.swing.*;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainFrame extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("JVerify Beta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MainPanel());
        setVisible(true);
    }
}
