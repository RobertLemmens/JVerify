package codebulb.controllers;

import codebulb.engines.TrackingEngine;
import codebulb.factories.HashedFilesFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 */


public class TrackingController {

    private ArrayList<File> files;

    private TrackingEngine tracker;

    public TrackingController() {
        files = new ArrayList<File>();
    }

    public void startTracker() {
        tracker = new TrackingEngine();
        tracker.start();
    }

    public void stopTracker() {
        tracker.stop();
        tracker = null;
    }

    public void updateTreeView() {

    }

    public ArrayList<File> getFiles() {
        return files;
    }

}
