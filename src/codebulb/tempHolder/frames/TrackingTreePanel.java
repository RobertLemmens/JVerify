package codebulb.tempHolder.frames;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robert Lemmens on 22-11-2014.
 */

public class TrackingTreePanel extends JPanel implements ActionListener {

    private JTree tree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode[] subs;
    private JScrollPane scroll;


    public TrackingTreePanel() {
        //setBackground(Color.orange);
    }

    public void createTree(String rootFolder, ArrayList<File> files) {
        if(tree != null)
            remove(tree);
        if(scroll != null)
            remove(scroll);

        scroll = null;
        tree = null;
        root = null;
        subs = null;
        root = new DefaultMutableTreeNode(rootFolder);
        subs = new DefaultMutableTreeNode[files.size()];

        for(int i = 0; i < subs.length; i++) {
            subs[i] = new DefaultMutableTreeNode(files.get(i).getName());
            root.add(subs[i]);
        }

        tree = new JTree(root);
        scroll = new JScrollPane(tree);

        add(scroll);
    }



    public void actionPerformed(ActionEvent e) {

       // do iets
    }

}