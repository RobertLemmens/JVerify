package codebulb.frames;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 7-10-2014.
 */
public class ResultFrame extends JFrame{

    JTextArea results;

    ArrayList<String> md5Lijst;
    ArrayList<String> fileLijst;

    public ResultFrame(){

        setSize(800,700);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel paneel = new JPanel();
        paneel.setLayout(null);
        results = new JTextArea();
        results.setSize(800,700);
        results.setEditable(false);

        add(paneel);
        paneel.add(results);
    }

    public void updateLijst(ArrayList<String> md5Lijst, ArrayList<String> fileLijst) {
        this.md5Lijst = md5Lijst;
        this.fileLijst = fileLijst;
        results.setText(null);
        for(int i = 0; i < this.fileLijst.size(); i++) {
            results.append(this.fileLijst.get(i));
            System.out.println(fileLijst.get(i));
            results.append("\n");
            results.append(this.md5Lijst.get(i));
            results.append("\n\n");
        }
    }

}
