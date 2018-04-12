package codebulb.interfaces;

import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 *
 * Simple interface for the hash engines
 */
public interface HashEngineInterface {

    /**
     * Set a file to hash
     *
     * @param file file to hash
     */
    public void setFile(File file);

    /**
     * Run the hasher. This generates the HashedFile object and prints the
     * result to the result view
     */
    public void runHasher();

    /**
     * Get checksum returns the result from the last hashed file
     *
     * @return a hash
     */
    public String getChecksum();

}
