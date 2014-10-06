package codebulb.frames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */

public class MD5Paneel extends JPanel {

    private JButton browse;

    private JTextArea md5;
    private JLabel md5Label;
    private JTextArea file;
    private JLabel fileLabel;

    public MD5Paneel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        md5 = new JTextArea();
        md5.setSize(200,20);
        md5.setLocation(10,300);

        md5Label = new JLabel("Paste md5 string:");
        md5Label.setSize(200,20);
        md5Label.setLocation(10, 280);
        md5Label.setForeground(Color.white);

        file = new JTextArea();
        file.setSize(200,20);
        file.setLocation(275,300);

        fileLabel = new JLabel("Browse file:");
        fileLabel.setSize(200,20);
        fileLabel.setLocation(275,280);
        fileLabel.setForeground(Color.white);
        

        browse = new JButton("Browse");
        browse.setSize(100,20);
        browse.setLocation(375,322);

        add(md5);
        add(md5Label);
        add(file);
        add(fileLabel);
        add(browse);
    }
}
