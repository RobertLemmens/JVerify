package codebulb.controllers;

import codebulb.engines.MD5Engine;
import codebulb.engines.Sha1Engine;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainController {

    /*
    this controller controls the other controllers and  the views
     */

    private HashedFilesFactory hashedFilesFactory;
    private HashingController hashingController;
    private TrackingController trackingController;

    private MainSouthPanel southPanel;
    private ResultFrame resultFrame;
    private ResultPanel resultPanel;
    private JTabbedPane tabs;

    private TrackingPanel trackingPanel;

    private ArrayList<Integer> filesInTracker;

    public static void main(String[] args) {

        if(args.length > 0) {
            if(args.length % 2 != 0) {
                System.out.println("Not enough arguments. Required args:\n" +
                        "-f, --file filename\n" +
                        "-m, --method hashing method(md5 or sha1)\n" +
                        "-h, --hash optional hash to check against");
            } else {
                cmdRunner(args);
            }
        } else {
            new MainController();
        }

    }

    public static void cmdRunner(String[] args) {
        Map<String, String> argMap = new HashMap<>();

        for(int i = 0; i < args.length; i+=2) {
            argMap.put(args[i], args[i+1]);
        }

        if(args.length % 2 != 0) {
            System.out.println("Not enough arguments");
        } else {
            File file = new File(argMap.get("-f"));
            String method = argMap.get("-m");
            String result = "";
            if(method.equals("md5")) {
                MD5Engine engine = new MD5Engine();
                engine.setFile(file);
                engine.runHasher();
                result = engine.getChecksum();
            } else if(method.equals("sha1")) {
                Sha1Engine engine = new Sha1Engine();
                engine.setFile(file);
                engine.runHasher();
                result = engine.getChecksum();
            }
            System.out.println(result);
            if(argMap.size() > 2) {
                String hashToCheck = argMap.get("-h");
                System.out.println(hashToCheck);
                if(hashToCheck.equals(result)) {
                    System.out.println("Hashes match.");
                } else {
                    System.out.println("Hashes don't match.");
                }
            }
        }
    }

    public MainController() {
        filesInTracker = new ArrayList<>();
        hashedFilesFactory = new HashedFilesFactory();

        // the hashingcontroller will be adding to the factory, so it will be given access.
        hashingController = new HashingController(hashedFilesFactory);

        trackingController = new TrackingController(this);

        // create the hashedfiles factory
       // HashedFilesFactory hashedFilesFactory= new HashedFilesFactory();

        // maak de views
        MainPanel hoofdPaneel = new MainPanel(this);

        // create the main tab holder
        tabs = new JTabbedPane();
        tabs.setSize(MainFrame.WIDTH - 8, MainFrame.HEIGHT - 30);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        //create the individual tabs with a panel on top of it

        trackingPanel = new TrackingPanel(this);
        tabs.addTab("MD5", new MD5Panel(this));
        tabs.addTab("Sha", new ShaPanel(this));
        tabs.addTab("Tracker", trackingPanel);

        //create the southern control panel
        southPanel = new MainSouthPanel(this);

        // voeg de components toe op het hoofdpaneel
        hoofdPaneel.add(tabs, BorderLayout.CENTER);
        hoofdPaneel.add(southPanel, BorderLayout.SOUTH);

        // maak de result view
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

    public void updateTheNeedy(File f) {
        trackingPanel.update(f);
    }

    public JTabbedPane tabAction() {
        return tabs;
    }

    public void addToTrackedFiles(int i){
        filesInTracker.add(i);
    }

    public ArrayList<Integer> getTrackedFileIDs(){
        return filesInTracker;
    }
}
