package codebulb.controllers;

import codebulb.factories.HashedFilesFactory;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainController {

    // this controller controls the other controllers and directly controls the views

    private HashedFilesFactory hashedFilesFactory;

    private HashingController hashingController;
    private TrackingController trackingController;

    public MainController() {
        hashedFilesFactory = new HashedFilesFactory();

        hashingController = new HashingController();
        trackingController = new TrackingController();

    }

}
