package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.models.HashedFile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 */

public class ResultPanel extends JPanel{

    private JTextArea resultaatVeld;
    private JScrollPane scroll;
    private int myLocation;
    private ArrayList<HashedFile> hashedFiles;

    private MainController controller;

    public ResultPanel(MainController controller) {
        setLayout(new BorderLayout());
        this.controller = controller;
        resultaatVeld = new JTextArea();
        resultaatVeld.setEditable(false);

        scroll = new JScrollPane(resultaatVeld);


        add(scroll, BorderLayout.CENTER);

        hashedFiles = controller.getFiles();

        myLocation = 0;
    }

    public void setMyLocation(int x){
        myLocation = x;
    }



    ///////// Add alle files in dezelfde lijst
    ///////// return alleen degene van toepassing. Te vinden via het unieke ID!

    public void update() {
        System.out.println("Updating resultpanel");
        hashedFiles = controller.getFiles();
        ArrayList<HashedFile> trackTemp = new ArrayList<>();

        for(HashedFile hashedFile : hashedFiles){
            if(hashedFile.amITracked() && myLocation == 1){
                trackTemp.add(hashedFile);
            } else if(!hashedFile.amITracked() && myLocation == 0) {
                trackTemp.add(hashedFile);
            }
        }

        String s = "";

        for(HashedFile file : trackTemp) {
            s += file.getFileName() + "\n |\nmd5 --> " + file.getMd5Hash() + "\nsha1 --> " + file.getSha1Hash() + "\nsha256 -->" + file.getSha2Hash() + "\nsha512 --> " + file.getSha5Hash() + "\n\n";
        }
        //resultaatVeld.setText(g);
        resultaatVeld.setText(s);
    }

}
