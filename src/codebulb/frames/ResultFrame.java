package codebulb.frames;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 7-10-2014.
 */
public class ResultFrame extends JFrame{


    public ResultFrame(ArrayList<String> md5Lijst, ArrayList<String> fileLijst){
        setSize(500,700);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel paneel = new JPanel();
        JTextArea results = new JTextArea();
        results.setSize(400,500);
        results.setEditable(false);



        for(int i = 0; i < fileLijst.size(); i++) {
            results.append(fileLijst.get(i));
            results.append("\n");
            results.append(md5Lijst.get(i));
            results.append("\n\n");
        }
        add(paneel);
        paneel.add(results);
    }

}
