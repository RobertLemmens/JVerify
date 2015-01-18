package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.factories.HashedFilesFactory;
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
        // create the hashedfiles factory
        HashedFilesFactory hashedFilesFactory= new HashedFilesFactory();

        // create the main controller
        MainController controller = new MainController(hashedFilesFactory);

        // create the main tab holder
        JTabbedPane tabs = new JTabbedPane();
        tabs.setSize(MainFrame.WIDTH-8, MainFrame.HEIGHT-30);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        //create the individual tabs with a panel on top of it
        tabs.addTab("MD5", new MD5Panel(controller));
        tabs.addTab("Sha", new ShaPanel(controller));
        tabs.addTab("Tracker", new TrackingPanel(controller));

        add(tabs);
    }

}
