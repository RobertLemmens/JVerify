package codebulb.frames;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert Lemmens on 22-11-2014.
 */

public class TrackingTreePanel extends JPanel implements ActionListener {

    private JTree tree;


    public TrackingTreePanel() {
        setBackground(Color.orange);


        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Rootfolder");
        DefaultMutableTreeNode testNode = new DefaultMutableTreeNode("Subitem");
        DefaultMutableTreeNode testNode2 = new DefaultMutableTreeNode("Subitem");
        DefaultMutableTreeNode testNode3 = new DefaultMutableTreeNode("Subsubitem");
        testNode.add(testNode3);

        root.add(testNode);
        root.add(testNode2);

        tree = new JTree(root);
        add(tree);
    }

    public void createTree() {

    }



    public void actionPerformed(ActionEvent e) {

       // do iets
    }

}