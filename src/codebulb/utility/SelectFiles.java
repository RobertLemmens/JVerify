package codebulb.utility;

import javax.swing.*;
import java.io.File;

/**
 * Created by Robert on 10-Sep-15.
 */
public class SelectFiles {

    public SelectFiles() {

    }

    public File getFile() {
        File f = null;
        JFileChooser chooser = new JFileChooser();

        chooser.setDialogTitle("Open folder to track");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
           f = chooser.getSelectedFile();
        } else {
            System.out.println("Lege selectie");
        }

        return f;
    }
}
