package codebulb.tempHolder.engine;

import codebulb.tempHolder.utility.WriteFiles;

import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class ManifestWriter {

    WriteFiles writer;
    public ManifestWriter(ArrayList<String> bestandsNamen, ArrayList<String> md5s) {
        writer = new WriteFiles();

    }



}
