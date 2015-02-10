package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.engines.TrackingEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert on 18-1-2015.
 */

// the southern control panel with the buttons for tracking

public class TrackingSouthPanel extends JPanel implements ActionListener{

    private JButton selectFolder;
    private JButton start;
    private JButton stop;

    private MainController controller;
    private TrackingPanel mainPanel;

    public TrackingSouthPanel(MainController controller, TrackingPanel mainPanel) { //todo wat doen met het mainpaneel?
        this.controller = controller;

        selectFolder = new JButton("Select folder");
        selectFolder.addActionListener(this);

        start = new JButton("Start");
        start.addActionListener(this);

        stop = new JButton("Stop");
        stop.addActionListener(this);

        add(selectFolder);
        add(start);
        add(stop);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(selectFolder)) {
            //todo add item selecter.
        }
        if(e.getSource().equals(start)) {
            controller.trackingEvent().startTracker();
        }
        if(e.getSource().equals(stop)) {
            controller.trackingEvent().stopTracker();
        }
    }
}
