package codebulb.views.panels;

import codebulb.views.frames.MainFrame;

import javax.swing.*;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainPanel extends JPanel{

    public MainPanel() {
        setLayout(null);
        createTabs();
    }

    private void createTabs() {
        // create the main tab holder
        JTabbedPane tabs = new JTabbedPane();
        tabs.setSize(MainFrame.WIDTH-8, MainFrame.HEIGHT-30);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        //create the individual tabs with a panel ontop of it
        tabs.addTab("MD5", new MD5Panel());


    }

}
