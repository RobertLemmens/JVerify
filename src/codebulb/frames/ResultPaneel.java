package codebulb.frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert on 18-12-2014.
 */
public class ResultPaneel extends JPanel{

    private JLabel header;
    private JScrollPane scroll;
    private JTextArea resultaatVeld;
    private Dimension veldDimensies;


    public ResultPaneel() {
        setLayout(new BorderLayout());
        System.out.println("Resultpaneel");
        header = new JLabel("Resultaten:");
        resultaatVeld = new JTextArea();

        scroll = new JScrollPane(resultaatVeld);
        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

    }


    public void setResultaatVeld(ArrayList<File> file, ArrayList<String> md5) {
        System.out.println("Setting results...");
        String s = "";
        int i = 0;
        for(File bestand : file) {
            s += bestand.getName() + "\n";
            s += md5.get(i) + "\n";
            s += "-----------------------------------------------------\n";
            i++;
        }

        resultaatVeld.setText(s);

    }



}
