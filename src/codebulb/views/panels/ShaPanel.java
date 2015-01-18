package codebulb.views.panels;

import codebulb.controllers.MainController;

import javax.swing.*;
import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class ShaPanel extends SuperTabPanel{

    private MainController controller;

    public ShaPanel(MainController controller){
        this.controller = controller;
        addFileDropper();
    }

    @Override
    public void digestFiles(File file) {
        controller.hashingEvent().createSha1Checksum(file);
    }
}
