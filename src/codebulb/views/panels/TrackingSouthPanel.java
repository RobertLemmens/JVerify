package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.engines.TrackingEngine;
import codebulb.utility.ReadFiles;
import codebulb.utility.SelectFiles;
import codebulb.utility.WriteFiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */

// the southern control panel with the buttons for tracking

public class TrackingSouthPanel extends JPanel implements ActionListener{

    private JButton selectFolder;
    private JButton start;
    private JButton stop;
    private JButton export;

    private MainController controller;
    private TrackingPanel mainPanel;

    public TrackingSouthPanel(MainController controller, TrackingPanel mainPanel) { //todo wat doen met het mainpaneel?
        this.controller = controller;
        this.mainPanel = mainPanel;

        selectFolder = new JButton("Select folder");
        selectFolder.addActionListener(this);

        start = new JButton("Start");
        start.addActionListener(this);

        stop = new JButton("Stop");
        stop.addActionListener(this);

        export = new JButton("Export");
        export.addActionListener(this);

        add(selectFolder);
        add(start);
        add(stop);
        add(export);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(selectFolder)) {
            controller.trackingEvent().getFolder();
        }
        if(e.getSource().equals(start)) {
            controller.trackingEvent().startTracker();
        }
        if(e.getSource().equals(stop)) {
            controller.trackingEvent().stopTracker();
        }
        if(e.getSource().equals(export)) {
            SelectFiles selectFiles = new SelectFiles();
            File folder = selectFiles.getFile();
            System.out.println("Writing to: " + folder.getAbsolutePath());
            WriteFiles fileWriter = new WriteFiles();
            System.out.println(mainPanel.getResults());
            fileWriter.writeTrackingResult(folder.getAbsolutePath(), mainPanel.getResults());
        }
    }
}
