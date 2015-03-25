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
    }

    public void update(){
        hashedFiles = controller.getFiles();

        String s = "";

        for(HashedFile file : hashedFiles) {
           s += file.getFileName() + "\n |\nmd5 --> " + file.getMd5Hash() + "\nsha1 --> " + file.getSha1Hash() + "\nsha256 -->" + file.getSha2Hash() + "\nsha512 --> " + file.getSha5Hash() + "\n\n";
        }

        resultaatVeld.setText(s);


    }

}
