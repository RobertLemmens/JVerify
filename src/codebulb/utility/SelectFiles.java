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

        chooser.setDialogTitle("Choose tracking folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        //todo fix >>??

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
           f = chooser.getSelectedFile();
        } else {
            System.out.println("Lege selectie");
        }

        return f;
    }
}
