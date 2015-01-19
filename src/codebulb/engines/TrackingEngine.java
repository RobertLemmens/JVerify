package codebulb.engines;

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


    public synchronized void start() {
        draad = new Thread(this);
        isRunning = true;
        draad.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            draad.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        draad = null;
    }


    @Override
    public void run() {
        while(isRunning) {
            System.out.println("Threading like a bosssssss");
        }
    }
}
