package codebulb.frames;

import codebulb.engine.Hasher;
import codebulb.utility.FileDrop;
import codebulb.utility.ReadFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */

public class MD5Paneel extends JPanel implements ActionListener, MouseListener{

    private JButton browse;
    private JPanel dropPanel;
    private JTextArea md5;
    private JLabel md5Label;

    private JTextArea file;
    private JLabel fileLabel;
    private JLabel fileMD5;
    private Color bgc = new Color(50,50,50);

    public MD5Paneel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        md5 = new JTextArea();
        md5.setSize(200,20);
        md5.setLocation(150,300);

        md5Label = new JLabel("Paste md5 string:");
        md5Label.setSize(200,20);
        md5Label.setLocation(150, 280);
        md5Label.setForeground(Color.white);

        fileMD5 = new JLabel("");
        fileMD5.setSize(300,20);
        fileMD5.setLocation(120,350);
        fileMD5.setForeground(Color.white);


        add(md5);
        add(md5Label);
        add(fileMD5);

        // image path moet nog project relatief gemaakt worden
        ImageIcon uploadIcon = new ImageIcon("C:\\Users\\Robert\\IdeaProjects\\JVerify-1.0\\res\\images\\small65.png");
        JLabel uploadLabel = new JLabel(uploadIcon);
        uploadLabel.setSize(128,128);
        uploadLabel.setLocation(35,30);

        add(uploadLabel);

        dropPanel = new JPanel();
        dropPanel.setLayout(null);
        dropPanel.setSize(200, 200);
        dropPanel.setLocation(150, 10);
        dropPanel.setBackground(bgc);
        dropPanel.addMouseListener(this);
        dropPanel.add(uploadLabel);
        new FileDrop( dropPanel, new FileDrop.Listener() {
             public void filesDropped( java.io.File[] files ) {
                for(int i = 0; i < files.length; i++) {
                    System.out.println(files[i].getAbsoluteFile());
                    Hasher hasher = new Hasher(files[i]);

                    // create and get md5 from hasher
                    String md5 = hasher.getMD5Checksum();

                    // display md5 to user
                    fileMD5.setText("md5: " + md5);
                }
             }
             // end filesDropped
        });
        // end FileDrop.Listener
        add(dropPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         Browse knop bestaat niet meer! Alle interactie is over naar het drop paneel = dropPanel, zie mouselistener
         */
        if(e.getSource().equals(browse)){
            // create and open a filechooser
            ReadFiles reader = new ReadFiles();
            File file = reader.chooseFile();

            // create a hashing object from the file
            Hasher hasher = new Hasher(file);
            this.file.setText(file.getAbsolutePath());

            // create and get md5 from hasher
            String md5 = hasher.getMD5Checksum();

            // display md5 to user
            fileMD5.setText("md5: " + md5);
            // test test 
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ReadFiles reader = new ReadFiles();
        File file = reader.chooseFile();

        // create a hashing object from the file
        Hasher hasher = new Hasher(file);

        // create and get md5 from hasher
        String md5 = hasher.getMD5Checksum();

        // display md5 to user
        fileMD5.setText("md5: " + md5);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
