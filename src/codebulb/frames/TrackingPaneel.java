package codebulb.frames;

import codebulb.engine.FolderTracker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class TrackingPaneel extends JPanel {

    JPanel controlPanel;
    TrackingTreePanel treeView;
    FolderTracker tracker;

    public TrackingPaneel() {
        setLayout(new BorderLayout());

        initiate();

    }

    public void initiate() {
        treeView = new TrackingTreePanel();
        tracker = new FolderTracker(this, treeView);


        controlPanel = new TrackingControls(tracker);

        add(controlPanel, BorderLayout.SOUTH);

    }



}
