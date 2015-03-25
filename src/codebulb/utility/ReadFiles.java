package codebulb.utility;


import javax.swing.*;
import java.io.File;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class ReadFiles {

    public ReadFiles() {

    }

    public File autoFile(String path) {
        File file = new File(path);

        return file;
    }

    public File chooseFile() {
        File file = null;
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(new JFrame());

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }

        return file;
    }

}
