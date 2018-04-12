package codebulb.views.frames;

import javax.swing.*;

/**
 * Created by Robert on 18-1-2015.
 */
public class ResultFrame extends JFrame{

    private static int WIDTH = 500;
    private static int HEIGHT = 500;

    public ResultFrame() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("JVerify");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
