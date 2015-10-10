package codebulb.views.panels;

import codebulb.controllers.MainController;
import codebulb.controllers.TrackingController;
import sun.applet.Main;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

/**
 * Created by Robert on 1-2-2015.
 */
public class TrackingTreePanel extends JPanel {

    private MainController controller;
    private JTree tree;
    private DefaultMutableTreeNode top;
    private DefaultMutableTreeNode category = null;
    private JScrollPane treeView;

    public TrackingTreePanel(MainController controller) {
        this.controller = controller;

        top = new DefaultMutableTreeNode("Found files");
        createNodes();
        tree = new JTree(top);

        treeView = new JScrollPane(tree);
        add(treeView);
    }

    public void createNodes() {
        category = new DefaultMutableTreeNode("Hashed files");
        top.add(category);
    }

    public void addNodes(File f) {
        category.add(new DefaultMutableTreeNode(f.getAbsolutePath()));
    }

    public void refreshTree() {
        top.removeAllChildren();
        top.add(category);
        tree.revalidate();
        treeView.revalidate(); // pls
        treeView.repaint(); // why no work
        repaint();

    }

}
