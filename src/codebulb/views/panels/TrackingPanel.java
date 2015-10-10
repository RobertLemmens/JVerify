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

    private JSplitPane splitter;
    private TrackingTreePanel treePanel;
    private ResultPanel resultPanel;


    public TrackingPanel(MainController controller) {

        this.controller = controller;

        setLayout(new BorderLayout());
        createSplits();

        add(new TrackingSouthPanel(controller, this), BorderLayout.SOUTH);
    }

    public void createSplits() {

        treePanel = new TrackingTreePanel(controller);

        resultPanel = new ResultPanel(controller);
        
        splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, resultPanel); //todo ON UPDATE, ROEP resultPanel.UPDATE() aan! Check voor update in?

        add(splitter, BorderLayout.CENTER);

    }

    public void update(File f) { //todo update treepanel + resultpanel?
        resultPanel.update();

        System.out.println("Trackingpanel recieved an update!");

        treePanel.addNodes(f);
        treePanel.refreshTree();
        repaint();
    }

    public void createResultPane() {

    }


    @Override
    public void digestFiles(File file) {

    }
}
