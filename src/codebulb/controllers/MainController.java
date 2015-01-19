package codebulb.controllers;

import codebulb.factories.HashedFilesFactory;
import codebulb.models.HashedFile;
import codebulb.views.frames.MainFrame;
import codebulb.views.frames.ResultFrame;
import codebulb.views.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainController {

    /*




    this controller controls the other controllers and controls / creates the views




     */

    private HashedFilesFactory hashedFilesFactory;
    private HashingController hashingController;
    private TrackingController trackingController;

    private MainSouthPanel southPanel;
    private ResultFrame resultFrame;
    private ResultPanel resultPanel;

    public static void main(String[] args) {
        new MainController();
    }

    public MainController() {

        hashedFilesFactory = new HashedFilesFactory();

        // the hashingcontroller will be adding to the factory, so it will be given access.
        hashingController = new HashingController(hashedFilesFactory);

        trackingController = new TrackingController();

        // create the hashedfiles factory
        HashedFilesFactory hashedFilesFactory= new HashedFilesFactory();

        // maak de views
        MainPanel hoofdPaneel = new MainPanel(this);

        // create the main tab holder
        JTabbedPane tabs = new JTabbedPane();
        tabs.setSize(MainFrame.WIDTH-8, MainFrame.HEIGHT-30);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        //create the individual tabs with a panel on top of it
        tabs.addTab("MD5", new MD5Panel(this));
        tabs.addTab("Sha", new ShaPanel(this));
        tabs.addTab("Tracker", new TrackingPanel(this));

        //create the southern control panel
        southPanel = new MainSouthPanel(this);

        // voeg de components toe op het hoofdpaneel
        hoofdPaneel.add(tabs, BorderLayout.CENTER);
        hoofdPaneel.add(southPanel, BorderLayout.SOUTH);

        // maak de result views
        resultFrame = new ResultFrame();
        resultPanel = new ResultPanel(this);
        resultFrame.add(resultPanel);

        // maak een menubar
        JMenuBar menubar = new JMenuBar();
        JMenu view = new JMenu("View");

        JMenuItem results = new JMenuItem("Results");
        results.setMnemonic(KeyEvent.VK_R);
        results.setToolTipText("Show the results");
        results.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultFrame.setVisible(true);
            }
        });

        view.add(results);
        menubar.add(view);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setJMenuBar(menubar);
        mainFrame.add(hoofdPaneel);

    }

    // provide access to the controllers //

    public TrackingController trackingEvent() {
        return trackingController;
    }

    public HashingController hashingEvent() {
        return hashingController;
    }

    public ArrayList<HashedFile> getFiles() {
        return hashedFilesFactory.getAllHashedFiles();
    }

    public void updateTheNeedy() {
        southPanel.updateList();
        resultPanel.update();
    }

}
