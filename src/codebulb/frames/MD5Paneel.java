package codebulb.frames;

import codebulb.engine.HashVerifier;
import codebulb.engine.Hasher;
import codebulb.utility.FileDrop;
import codebulb.utility.ReadFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */

public class MD5Paneel extends JPanel implements ActionListener, MouseListener, KeyListener{

    private JButton check;
    private JPanel dropPanel;
    private JTextArea md5Field;
    private JLabel md5Label;

    private JTextArea file;
    private JLabel fileLabel;
    private JLabel fileMD5;
    private Color bgc = new Color(50,50,50);

    // Global list to save the generated MD5's / filepaths for when you drop multiple files.
    private ArrayList<String> md5Lijst;
    private ArrayList<String> fileLijst;
    private ArrayList<String> fileNames;
    private JComboBox comboBox;

    private int fieldCounter = 1;
    private int selectedFile = 0;

    public MD5Paneel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        md5Lijst = new ArrayList<String>();
        fileLijst = new ArrayList<String>();
        fileNames = new ArrayList<String>();
        Dimension fieldDim = new Dimension(140,240);
        //
        md5Field = new JTextArea();

        md5Field = new JTextArea();
        md5Field.setSize(220, 20);
        md5Field.setLocation(fieldDim.width, fieldDim.height);
        md5Field.setText("");
        md5Field.addKeyListener(this);
        add(md5Field);
        System.out.println("added");


        check = new JButton("Check");
        check.setSize(100,20);
        check.setLocation(380, 400);
        check.addActionListener(this);
        add(check);

        md5Label = new JLabel("Paste md5 string:");
        md5Label.setSize(200,20);
        md5Label.setLocation(150, 220);
        md5Label.setForeground(Color.white);

        comboBox = new JComboBox(fileLijst.toArray());
        comboBox.addActionListener(this);
        comboBox.setSize(220,20);
        comboBox.setLocation(140, 270);



        add(comboBox);
        add(md5Label);


        // image path moet nog project relatief gemaakt worden
        ImageIcon uploadIcon = new ImageIcon("images/small65.png");
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
        FileDrop dropper = new FileDrop( dropPanel, new FileDrop.Listener() {
             public void filesDropped( java.io.File[] files ) {
                 // grab files ( Multiple files may be added)
                for(int i = 0; i < files.length; i++) {
                    // create and compare (if possible) md5 sums
                    MD5Event(files[i]);
                    // print the result

                }
                 /*
                 OPEN EEN FRAME MET RESULTS NADAT DE LISTENER KLAAR IS MET FILES ADDEN / BEWERKEN
                  */
                 // Pass md5list and filepaths to resultframe
                 createResults();
             }
             // end filesDropped
        });
        // end FileDrop.Listener
        add(dropPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("ACTION");
        if(e.getSource().equals(check)) {
            selectedFile = comboBox.getSelectedIndex();

            boolean temp = matcher(md5Lijst.get(selectedFile), md5Field.getText());
            System.out.println("file " + ": " + temp);
        } else {

        }
    }
    // hier worden de md5's van de bestanden gemaakt.
    public void MD5Event(File file) {
        // create a hashing object from the file
        Hasher hasher = new Hasher(file);

        // create and get md5 from hasher
        String md5 = hasher.getMD5Checksum();

        // return the result en sla de generated MD5 van de file op in de lijst.
        fileLijst.add(file.getAbsolutePath());
        fileNames.add(file.getName());
        md5Lijst.add(md5);

    }

    // hier worden de resultaten in een frame verwerkt en klaargezet in de combobox om vergeleken te worden
    public void createResults() {
        // Pass md5list and filepaths to resultframe
        ResultFrame results = new ResultFrame(md5Lijst, fileLijst);

                 /*
                   update combobox met de nieuw(e) toegevoegde items
                  */
        comboBox.removeAllItems();
        for(int i = 0; i < fileNames.size(); i++) {
            comboBox.addItem(fileNames.get(i));
        }
    }

    public boolean matcher(String md5, String fieldmd5) {
        // create verify object and compare md5. Returns true if matched
        HashVerifier verify = new HashVerifier();
        String inputmd5 = md5Field.getText();
        boolean isMatch = verify.compare(md5, fieldmd5);

        return isMatch;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // grab a file
        ReadFiles reader = new ReadFiles();
        File file = reader.chooseFile();

        // create and compare (if textfield is not empty) md5 sums
        MD5Event(file);
        createResults();


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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_ENTER:

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
