package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.models.HashedFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Robert on 18-1-2015.
 */
public class MainSouthPanel extends JPanel implements ActionListener{

    private ArrayList<HashedFile> files;
    private JComboBox comboBox;
    private MainController controller;
    private JButton check;
    private JTextField hashField;

    public MainSouthPanel(MainController controller) {
        this.controller = controller;

        files = controller.getFiles();
        comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension(200,20));

        check = new JButton("Check");
        check.addActionListener(this);

        hashField = new JTextField();
        hashField.setPreferredSize(new Dimension(200,20));
        add(hashField);
        add(comboBox);
        add(check);
    }

    public void updateList() {
        System.out.println("updating");
        files = controller.getFiles();
        System.out.println(controller.getFiles().size()); // for debugging reasons
        comboBox.removeAllItems();

        for(HashedFile file : files){
            comboBox.addItem(file.getFileName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(check)){
            System.out.println("Checking");
            String hash1 = "";
            // in welk paneel zitten we?
            if(controller.tabAction().getSelectedIndex() == 0)
                hash1 = files.get(comboBox.getSelectedIndex()).getMd5Hash();
            else if(controller.tabAction().getSelectedIndex() == 1)
                hash1 = files.get(comboBox.getSelectedIndex()).getSha1Hash();

            String hash2 = hashField.getText();
            System.out.println(hash1);
            System.out.println(hash2);
            if(hash1.equals(hash2))
                JOptionPane.showMessageDialog(null, "The hashes match", "Match", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "The hashes don't match", "No match", JOptionPane.WARNING_MESSAGE);
        }
    }
}
