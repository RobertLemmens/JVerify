package codebulb.factories;

import codebulb.models.HashedFile;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 */
public class HashedFilesFactory {

    private ArrayList<HashedFile> hashedFileArrayList;

    public HashedFilesFactory() {
        hashedFileArrayList = new ArrayList<HashedFile>();
    }

    // passing the entire file just in case i want to do something with it later on
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

    public void remove(File file) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(file.getName().equals(hashedFileArrayList.get(i).getFileName())){
                hashedFileArrayList.remove(i);
            }
        }
    }

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

    public void addSha1ToFile(String fileName, String sha) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setSha1Hash(sha);
            }
        }
    }

    public void addSha2ToFile(String fileName, String sha) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setSha2Hash(sha);
            }
        }
    }

    public void addSha5ToFile(String fileName, String sha) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName())) {
                hashedFileArrayList.get(i).setSha5Hash(sha);
            }
        }
    }

    // providing two methods, not sure which one i will be using yet.
    public HashedFile getHashedFile(String fileName) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(fileName.equals(hashedFileArrayList.get(i).getFileName()))
                return hashedFileArrayList.get(i);
        }
        return null;
    }

    public HashedFile getHashedFile(File file) {
        for(int i = 0; i < hashedFileArrayList.size(); i++) {
            if(file.getName().equals(hashedFileArrayList.get(i).getFileName()))
                return hashedFileArrayList.get(i);
        }
        return null;
    }

    public ArrayList<HashedFile> getAllHashedFiles() {
        return hashedFileArrayList;
    }

}
