package codebulb.controllers;

import codebulb.factories.HashedFilesFactory;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainController {

    // this controller controls the other controllers

    HashedFilesFactory hashedFilesFactory;

    public MainController() {
        hashedFilesFactory = new HashedFilesFactory();
    }

}
