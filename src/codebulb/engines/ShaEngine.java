package codebulb.engines;

import codebulb.interfaces.HashEngineInterface;

import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public class ShaEngine implements HashEngineInterface{

    private File file;

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void runHasher() {

    }

    @Override
    public String getChecksum() {
        return null;
    }
}
