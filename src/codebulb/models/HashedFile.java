package codebulb.models;

/**
 * Created by Robert on 18-1-2015.
 * A model for a hashedfile.
 *
 * A HashedFile contains the filename and the created hashes together with an ID(Based on hash counter).
 */
public class HashedFile {

    public static int hashCounter = 0; //keep track of all hashed files

    private int uniekID;
    private String fileName;
    private String md5Hash;
    private String sha1Hash;
    private String sha2Hash;
    private String sha5Hash;

    private boolean tracked = false;

    public HashedFile() {
        hashCounter++; // start at 1 for the object counter

        uniekID = hashCounter; // give this object the current count number to uniquely identify it.

    }

    public void setTracked(boolean tracked){
        this.tracked = tracked;
    }

    public boolean amITracked(){
        return tracked;
    }

    public int getUniekID() {
        return uniekID;
    }

    public String getSha5Hash() {
        return sha5Hash;
    }

    public void setSha5Hash(String sha5Hash) {
        this.sha5Hash = sha5Hash;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMd5Hash() {
        return md5Hash;
    }

    public void setMd5Hash(String md5Hash) {
        this.md5Hash = md5Hash;
    }

    public String getSha1Hash() {
        return sha1Hash;
    }

    public void setSha1Hash(String sha1Hash) {
        this.sha1Hash = sha1Hash;
    }

    public String getSha2Hash() {
        return sha2Hash;
    }

    public void setSha2Hash(String sha2Hash) {
        this.sha2Hash = sha2Hash;
    }



}
