package codebulb.engine;

import codebulb.frames.TrackingPaneel;
import codebulb.frames.TrackingTreePanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class FolderTracker implements Runnable{

    private boolean isRunning = false;
    private Thread draad;
    private ArrayList<File> rootItems;
    private String rootPath;
    public int firstRun = 0;
    private TrackingPaneel paneel;
    private TrackingTreePanel tree;

    public FolderTracker(TrackingPaneel paneel, TrackingTreePanel tree) {
        this.paneel = paneel;
        this.tree = tree;
        rootItems = new ArrayList<File>();
        System.out.println(rootItems.size());
    }

    public void setRootPath(String rootPath){
        this.rootPath = rootPath;
    }


    public void Start() {
        isRunning = true;
        draad = new Thread(this);
        draad.start();
    }

    public ArrayList<File> getFiles() {
        return rootItems;
    }


    public void run() {

        while(isRunning) {

            File f = new File(rootPath);

                // eerste run wordt alles geadd en niet gechecked wat er al in de folder zit
                if(firstRun == 0) {
                    for(int j = 0; j < f.listFiles().length; j++) {
                        rootItems.add(f.listFiles()[j]);
                        System.out.println(f.listFiles()[j].toString());
                    }
                    tree.createTree(rootPath, getFiles());
                    paneel.add(tree, BorderLayout.WEST);
                    paneel.revalidate();
                    tree.revalidate();
                    firstRun = 1;
                }
                else {
                    if(f.listFiles().length == rootItems.size()) {
                        System.out.println("Niets nieuws.");
                    }
                    else {
                        for(int i = 0; i < f.listFiles().length; i++) {
                            if(rootItems.contains(f.listFiles()[i])) {
                                System.out.println("Deze zit er in");
                            }
                            else {
                                System.out.println("Zit er niet in");
                                rootItems.add(f.listFiles()[i]);
                            }
                        }
                        // remove de tree, en add de tree met de updates.
                        paneel.remove(tree);
                        tree.createTree(rootPath, getFiles());

                        paneel.add(tree, BorderLayout.WEST);
                        paneel.revalidate();
                    }
                }

            System.out.println(rootItems.size());
            if(f.isDirectory()) {
                System.out.println("Dit is een directory");
            }
            else if(f.isFile()) {
                System.out.println("Dit is een bestand");
            }
            else {
                System.out.println("Ik heb geen idee wat dit is");
            }





            // even stoppen.
            try {

                //paneel.repaint();
                Thread.sleep(2000);
                firstRun = 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
