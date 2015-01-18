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

    public TrackingPanel(MainController controller) {

        this.controller = controller;

        setLayout(new BorderLayout());

        add(new TrackingSouthPanel(controller), BorderLayout.SOUTH);
    }

    @Override
    public void digestFiles(File file) {

    }
}
