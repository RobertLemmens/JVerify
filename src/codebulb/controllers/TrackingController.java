package codebulb.controllers;

import codebulb.engines.TrackingEngine;
import codebulb.factories.HashedFilesFactory;
import codebulb.utility.SelectFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Robert on 18-1-2015.
 */


public class TrackingController {

    private HashSet<File> files;
    private TrackingEngine tracker;
    private static SelectFiles selectFiles;
    private String folderToTrack = "";

    private MainController controller;

    public TrackingController(MainController controller) {
        files = new HashSet<File>();

        selectFiles = new SelectFiles();

        this.controller = controller;

    }

    public HashedFilesFactory hashedFilesFactory; // nieuwe voor de tracker ( hou de tracker en de ad-hoc gescheiden

    public void startTracker() {
        tracker = new TrackingEngine(folderToTrack, this);
        tracker.start();
    }

    public void stopTracker() {
        tracker.stop();
        tracker = null;
    }

    public String getFolder() {

        File tempFile = selectFiles.getFile();
        if (tempFile == null) {
            System.out.println("No file selected / selection cancelled");
            return "stop";
        } else {
            System.out.println("Selected folder: " + tempFile.getAbsolutePath());
            System.out.println("We good boys");
            folderToTrack = tempFile.getAbsolutePath();
        }
        return tempFile.getAbsolutePath();
    }

    public void updateTreeView(File f) {
        controller.updateTheNeedy(f);
    }

    public HashSet<File> getFiles() {
        return files;
    }

    public void addToFiles(File f) {
        files.add(f);
    }

}
