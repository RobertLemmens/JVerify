package codebulb.views.panels;

import codebulb.controllers.MainController;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class TrackingPanel extends SuperTabPanel{

    private MainController controller;

    private ResultPanel resultPanel;

    public TrackingPanel(MainController controller) {

        this.controller = controller;

        setLayout(new BorderLayout());
        createSplits();

        add(new TrackingSouthPanel(controller, this), BorderLayout.SOUTH);
    }

    public void createSplits() {
        resultPanel = new ResultPanel(controller);
        resultPanel.setMyLocation(1);
        add(resultPanel);
    }

    public void update(File f) { //todo update treepanel + resultpanel?
        resultPanel.update();

        System.out.println("Trackingpanel recieved an update!");

        repaint();
    }

    public void createResultPane() {

    }


    @Override
    public void digestFiles(File file) {

    }
}
