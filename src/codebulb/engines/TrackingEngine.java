package codebulb.engines;

import codebulb.controllers.TrackingController;
import codebulb.models.HashedFile;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 */

/*

 this class is in charge of tracking the folder we've selected in the TrackingSouthPanel. It will notify the trackingcontroller of any newly found files. The trackingcontroller is in charge of telling the tree
 view that there is a new file so it can update itself.

 */
public class TrackingEngine implements Runnable{

    private boolean isRunning = false;

    private Thread draad;

    private String folderToTrack = "";

    private File trackedFolder;

    private TrackingController trackingController;

    public TrackingEngine(String folderToTrack, TrackingController trackingController) {
        this.folderToTrack = folderToTrack;
        trackedFolder = new File(folderToTrack);
        this.trackingController = trackingController;
    }

    public synchronized void start() {

        if(folderToTrack.equals("")) {
            System.out.println("No folder selected");
        } else {
            System.out.println("Starting thread");
            draad = new Thread(this);
            isRunning = true;
            draad.start();
        }
    }

    public synchronized void stop() {
        isRunning = false;
        if(isRunning == false) {
            System.out.println("Thread already stopped");
        } else {
            try {
                draad.join(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            draad = null;
        }
    }


    @Override
    public void run() {
        while(isRunning) {
            //System.out.println("Threading like a bosssssss");
            fileSearcher();

            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println("Thread mocht niet slapen");
            }
        }
    }

    int currentSize = 0;
    public void fileSearcher() {

        trackedFolder = new File(folderToTrack);

        for(File f : trackedFolder.listFiles()) {
            if(f.isFile()) {

                trackingController.addToFiles(f);

                if(trackingController.getFiles().size() > currentSize) {
                    System.out.println("A file was added.");
                    currentSize = trackingController.getFiles().size();
                    System.out.println("Size: " + currentSize);
                    trackingController.hashFile(f, true);
                    trackingController.addToUniekIdLijst(HashedFile.hashCounter);
                    trackingController.updateTreeView(f);
                }

                System.out.println("Elements in set: " + trackingController.getFiles().size());


            }
        }
    }







}
