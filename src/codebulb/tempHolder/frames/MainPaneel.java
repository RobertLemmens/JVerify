package codebulb.tempHolder.frames;

import javax.swing.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class MainPaneel extends JPanel{

    public MainPaneel() {
        setLayout(null);
        JTabbedPane tabs = new JTabbedPane();
        tabs.setSize(MainFrame.WIDTH-8, MainFrame.HEIGHT-30);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // create tabs
        tabs.addTab("MD5", new MD5Paneel());
        tabs.addTab("Sha-1/256/512", new Sha1Paneel());
        tabs.addTab("Folder tracking", new TrackingPaneel());


        // add
        add(tabs);

    }
}
