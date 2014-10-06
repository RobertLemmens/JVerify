package codebulb.frames;

import javax.swing.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */

public class MD5Paneel extends JPanel {

    private JButton button1 = new JButton("Test");

    public MD5Paneel() {
        setLayout(null);

        button1.setSize(100,20);
        button1.setLocation(200,200);

        add(button1);
    }
}
