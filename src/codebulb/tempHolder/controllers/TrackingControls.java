package codebulb.tempHolder.controllers;

import codebulb.tempHolder.engine.FolderTracker;
import codebulb.tempHolder.engine.Hasher;
import codebulb.tempHolder.frames.ResultPaneel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 21-11-2014.
 */
public class TrackingControls extends JPanel implements ActionListener{

    JButton select;
    JButton checkMD5;
    FolderTracker tracker;
    ResultPaneel resultPaneel;

    public TrackingControls(FolderTracker tracker, ResultPaneel resultPaneel) {
        this.tracker = tracker;
        this.resultPaneel = resultPaneel;

        setBackground(Color.darkGray);
        select = new JButton("Select folder");
        select.addActionListener(this);
        checkMD5 = new JButton("Create md5");
        checkMD5.addActionListener(this);

        add(select);
        add(checkMD5);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(select)) {

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Kies je folder");
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setAcceptAllFileFilterUsed(false);

            if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(chooser.getCurrentDirectory());
                tracker.setRootPath(chooser.getCurrentDirectory().toString());
                tracker.Start();

            }
            else{
                System.out.println("Geen selectie");
            }
        }

        if(e.getSource().equals(checkMD5)) {
            ArrayList<File> files = tracker.getFiles();
            ArrayList<String> md5 = new ArrayList<String>();

            for(int i = 0; i< files.size(); i++) {
                Hasher hasher = new Hasher(files.get(i));
                String s = hasher.getMD5Checksum();
                System.out.println(files.get(i).toString() + " md5: " + s);
                md5.add(s);
            }
            resultPaneel.setResultaatVeld(files, md5);
        }
    }
}
