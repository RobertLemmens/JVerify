package codebulb.tempHolder.frames;

import codebulb.tempHolder.controllers.TrackingControls;
import codebulb.tempHolder.engine.FolderTracker;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class TrackingPaneel extends JPanel {

    private JPanel controlPanel;
    private TrackingTreePanel treeView;
    private FolderTracker tracker;
    private ResultPaneel resultaatPaneel;

    public TrackingPaneel() {
        setLayout(new BorderLayout());

        initiate();

    }

    public void initiate() {
        treeView = new TrackingTreePanel();
        tracker = new FolderTracker(this, treeView);
        resultaatPaneel = new ResultPaneel();

        controlPanel = new TrackingControls(tracker, resultaatPaneel);

        add(controlPanel, BorderLayout.SOUTH);

        add(resultaatPaneel, BorderLayout.CENTER);

    }



}
