package codebulb.interfaces;

import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */
public interface HashEngineInterface {

    public void setFile(File file);

    public void runHasher();

    public String getChecksum();

}
