package codebulb.frames;


import javax.swing.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MainPaneel());
        setVisible(true);
    }
}
