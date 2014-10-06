package codebulb.frames;

import javax.swing.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class MainPaneel extends JPanel{

    public MainPaneel() {

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("MD5", new MD5Paneel());

        tabs.addTab("Sha-1", new Sha1Paneel());

        tabs.addTab("Folder tracking", new TrackingPaneel());

    }
}
