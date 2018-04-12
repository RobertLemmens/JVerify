package codebulb.factories;

import codebulb.models.HashedFile;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 *
 * Factory method for creating and managing all HashedFiles.
 *
 */
public class HashedFilesFactory {

    private ArrayList<HashedFile> hashedFileArrayList;

    public HashedFilesFactory() {
        hashedFileArrayList = new ArrayList<HashedFile>();
    }

    /**
     * Create a new hashedfile and
     * Add the new hashedfile to the list if its not a duplicate
     *
     * @param file
     */
    public void add(File file) {

        HashedFile temp = new HashedFile();

        temp.setFileName(file.getName());
        boolean duplicate = false;

        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(file.getName().equals(hashedFileArrayList.get(i).getFileName())) {
                System.out.println("File exists!");
                duplicate = true;
            }
        }

        if(!duplicate) {
            hashedFileArrayList.add(temp);
            System.out.println( "added in array");
        }

    }

    /**
     * Create a new hashedfile and
     * Add it to the list if its not a duplicate. Set tracked for the tracker available
     * @param file the file that got hashed
     * @param x indicate wether or not the file is tracked automaticly
     */
    public void add(File file, boolean x) {

        HashedFile temp = new HashedFile();
        temp.setTracked(x);
        temp.setFileName(file.getName());
        boolean duplicate = false;

        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(file.getName().equals(hashedFileArrayList.get(i).getFileName())) {
                System.out.println("File exists!");
                duplicate = true;
            }
        }

        if(!duplicate) {
            hashedFileArrayList.add(temp);
            System.out.println( "added in array");
        }

    }

    /**
     * Remove a file from the list
     *
     * @param file
     */
    public void remove(File file) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(file.getName().equals(hashedFileArrayList.get(i).getFileName())){
                hashedFileArrayList.remove(i);
            }
        }
    }

    /**
     * Add a md5 hash to a previously hashed file
     *
     * @param fileName
     * @param md5
     */
    public void addMd5ToFile(String fileName, String md5) {
        System.out.println("Setting md5");
        System.out.println(md5);
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setMd5Hash(md5);
                System.out.println("Md5 setted!");
            }
        }
    }

    /**
     * Add a sha1 hash to a previously hashed file
     *
     * @param fileName
     * @param sha
     */
    public void addSha1ToFile(String fileName, String sha) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setSha1Hash(sha);
            }
        }
    }

    /**
     * Add a sha2 hash to a previously hashed file
     *
     * @param fileName
     * @param sha
     */
    public void addSha2ToFile(String fileName, String sha) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setSha2Hash(sha);
            }
        }
    }

    /**
     * Add a sha5 hash to a previously hashed file
     *
     * @param fileName
     * @param sha
     */
    public void addSha5ToFile(String fileName, String sha) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setSha5Hash(sha);
            }
        }
    }

    /**
     * Get a hashedfile by its filename
     *
     * @param fileName filename
     * @return
     */
    public HashedFile getHashedFile(String fileName) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName()))
                return hashedFileArrayList.get(i);
        }
        return null;
    }

    /**
     * Get a hashedfile by its filename (Extracted from the File object)
     *
     * @param file
     * @return
     */
    public HashedFile getHashedFile(File file) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(file.getName().equals(hashedFileArrayList.get(i).getFileName()))
                return hashedFileArrayList.get(i);
        }
        return null;
    }

    /**
     * Return the list with hashedfiles
     *
     * @return
     */
    public ArrayList<HashedFile> getAllHashedFiles() {
        return hashedFileArrayList;
    }

}
