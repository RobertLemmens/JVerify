package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.views.panels.generic.SuperTabPanel;

import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class MD5Panel extends SuperTabPanel {

    private MainController controller;

    public MD5Panel(MainController controller) {
        this.controller = controller;
        addFileDropper();
    }

    @Override
    public void digestFiles(File file) {
        controller.hashingEvent().createMD5Checksum(file);
        controller.updateTheNeedy();
    }
}
