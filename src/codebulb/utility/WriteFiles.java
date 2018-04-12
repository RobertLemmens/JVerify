package codebulb.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class WriteFiles {

    public WriteFiles() {
    }

    /**
     * Write the scan results to a file
     *
     * @param folder Where to write to
     * @param textToWrite the text to write to the file
     */
    public boolean writeTrackingResult(String folder, String textToWrite) {
        File dir = new File(folder);

        if(!dir.exists()) {
            dir.mkdirs();
        }

        File results = new File(dir.getAbsoluteFile() + File.separator + "results.txt");

        try {
            PrintWriter writer = new PrintWriter(results);
            writer.write(textToWrite);
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
