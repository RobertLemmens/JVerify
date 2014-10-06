package codebulb.utility;

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
        File file = new File("");

        return file;
    }

}
