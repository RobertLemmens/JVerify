package codebulb.frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class TrackingPaneel extends JPanel {

    JPanel controlPanel;
    JPanel treeView;

    public TrackingPaneel() {
        setLayout(new BorderLayout());

        treeView = new TrackingTreePanel();
        controlPanel = new TrackingControls();

        add(treeView, BorderLayout.WEST);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public void initiate() {


    }



}
