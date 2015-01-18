package codebulb.views.panels;

import javax.swing.*;
import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class ShaPanel extends SuperTabPanel{

    public ShaPanel(){
        addFileDropper();
    }

    @Override
    public void digestFiles(File file) {

    }
}
