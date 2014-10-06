package codebulb.frames;

import codebulb.engine.Hasher;
import codebulb.utility.ReadFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */

public class MD5Paneel extends JPanel implements ActionListener{

    private JButton browse;

    private JTextArea md5;
    private JLabel md5Label;
    private JTextArea file;
    private JLabel fileLabel;

    private JLabel fileMD5;

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

        fileMD5 = new JLabel("test");
        fileMD5.setSize(200,20);
        fileMD5.setLocation(275,350);
        fileMD5.setForeground(Color.white);


        browse = new JButton("Browse");
        browse.setSize(100,20);
        browse.setLocation(375,322);
        browse.addActionListener(this);

        add(md5);
        add(md5Label);
        add(file);
        add(fileLabel);
        add(browse);
        add(fileMD5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(browse)){
            ReadFiles reader = new ReadFiles();
            File file = reader.chooseFile();
            Hasher hasher = new Hasher(file);
            this.file.setText(file.getAbsolutePath());

            // create and get md5
            String md5 = hasher.getMD5Checksum();

            // set text to display the user
            fileMD5.setText(md5);
        }
    }
}
