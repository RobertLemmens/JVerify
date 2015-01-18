package codebulb.controllers;

import codebulb.factories.HashedFilesFactory;
import codebulb.models.HashedFile;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainController {

    // this controller controls the other controllers and directly controls the views

    private HashedFilesFactory hashedFilesFactory;

    private HashingController hashingController;

    private TrackingController trackingController;

    public MainController(HashedFilesFactory hashedFilesFactory) {

       this.hashedFilesFactory = hashedFilesFactory;

        // the hashingcontroller will be adding to the factory, so it will be given access.
        hashingController = new HashingController(hashedFilesFactory);

        trackingController = new TrackingController();

    }

    // provide access to the controllers //

    public TrackingController trackingEvent() {
        return trackingController;
    }

    public HashingController hashingEvent() {
        return hashingController;
    }

}
