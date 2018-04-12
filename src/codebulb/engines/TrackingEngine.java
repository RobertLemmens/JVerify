package codebulb.engines;

import codebulb.controllers.TrackingController;
import codebulb.models.HashedFile;
import java.io.File;

/**
 * his class is in charge of tracking the folder we've selected in the TrackingSouthPanel. It will notify the trackingcontroller of any newly found files. The trackingcontroller is in charge of telling the tree
 *  view that there is a new file so it can update itself.
 */
public class TrackingEngine implements Runnable{

    private boolean isRunning = false;

    private Thread draad;

    private String folderToTrack = "";

    private File trackedFolder;

    private TrackingController trackingController;

    /**
     * Constructor sets the objects needed to start the thread
     *
     * @param folderToTrack
     * @param trackingController
     */
    public TrackingEngine(String folderToTrack, TrackingController trackingController) {
        this.folderToTrack = folderToTrack;
        trackedFolder = new File(folderToTrack);
        this.trackingController = trackingController;
    }

    /**
     * Start the thread. If theres no folder do nothing.
     */
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

    /**
     * Stop the thread.
     */
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

            fileSearcher();

            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Thread mocht niet slapen");
            }
        }
    }

    private int currentSize = 0;

    /**
     * Method that looks for new files in the supplied directory.
     *
     * Gets called every thread cycle.
     */
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
