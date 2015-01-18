package codebulb.tempHolder.frames;

import codebulb.tempHolder.engine.Hasher;
import codebulb.utility.FileDrop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class Sha1Paneel extends JPanel implements ActionListener, MouseListener{

    private JButton sha1;
    private JButton sha256;
    private JButton sha512;
    private JPanel dropPanel;
    private ResultFrame results;
    private Color bgc = new Color(50,50,50);

    private ArrayList<String> md5Lijst;
    private ArrayList<String> fileLijst;
    private ArrayList<String> fileNames;

    private JComboBox comboBox;
    public Sha1Paneel() {
        /**
         *Initiates
         */
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        md5Lijst = new ArrayList<String>();
        fileLijst = new ArrayList<String>();
        fileNames = new ArrayList<String>();
        Dimension fieldDim = new Dimension(140,240);

        sha1 = new JButton("Sha1");
        sha1.addActionListener(this);
        sha256 = new JButton("Sha256");
        sha256.addActionListener(this);
        sha512 = new JButton("Sha512");
        sha512.addActionListener(this);

        setBackground(Color.darkGray);

        /**
         * adds
         */
        add(sha1);
        add(sha256);
        add(sha512);

        comboBox = new JComboBox(fileLijst.toArray());
        comboBox.addActionListener(this);
        comboBox.setSize(220,20);
        comboBox.setLocation(140, 270);

        ImageIcon uploadIcon = new ImageIcon(this.getClass().getResource("../images/small65.png"));
        JLabel uploadLabel = new JLabel(uploadIcon);
        uploadLabel.setSize(128,128);
        uploadLabel.setLocation(35,30);
        System.out.println(this.getClass().getResource("../images/small65.png"));
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
                // Pass md5list and filepaths to resultframe (when clicked away, visibility is set false.)
                createResults();
                results.setVisible(true);
            }
            // end filesDropped
        });
        // end FileDrop.Listener
        add(dropPanel);

    }

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

    public void createResults() {
        // Pass md5list and filepaths to resultframe
        if(results == null)
            results = new ResultFrame();
        results.updateLijst(md5Lijst, fileLijst);

                 /*
                   update combobox met de nieuw(e) toegevoegde items
                  */
        comboBox.removeAllItems();
        for(int i = 0; i < fileNames.size(); i++) {
            comboBox.addItem(fileNames.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
