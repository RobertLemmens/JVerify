package codebulb.views.panels;

import codebulb.interfaces.TabPanelInterface;
import codebulb.utility.FileDrop;
import codebulb.utility.ReadFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by Robert on 18-1-2015.
 */




/*



 created this class to abstract out some of the methods gained from the implements, making the panels extending this class cleaner. Also defined the droppanel in here to reduce code length



 */
public abstract class SuperTabPanel extends JPanel implements TabPanelInterface, ActionListener, MouseListener, KeyListener {

    public SuperTabPanel() {
        setLayout(null);
        setBackground(Color.darkGray);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ReadFiles reader = new ReadFiles();
        File file = reader.chooseFile();

        if(file == null)
            return;
        else
            digestFiles(file);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void update() {

    }

    @Override
    public void notifyController() {

    }

    @Override
    public Color getBackgroundColor() {
        return new Color(50,50,50);
    }

    /// filedropper ///

    // call the hashcontroller and create a hash ( add to factory etc etc ).
    abstract public void digestFiles(File file);

    private JPanel dropPanel;

    public void addFileDropper() {
        System.out.println("adding dropper");
        ImageIcon uploadIcon = new ImageIcon(this.getClass().getResource("../../images/small65.png"));
        System.out.println(this.getClass().getResource("../../images/small65.png"));
        JLabel uploadLabel = new JLabel(uploadIcon);
        uploadLabel.setSize(128,128);
        uploadLabel.setLocation(35,30);

        dropPanel = new JPanel();
        dropPanel.setLayout(null);
        dropPanel.setSize(200,200);
        dropPanel.setLocation(150,10);
        dropPanel.setBackground(getBackgroundColor());
        dropPanel.addMouseListener(this);
        dropPanel.add(uploadLabel);

        FileDrop dropper = new FileDrop(dropPanel, new FileDrop.Listener() {
           public void filesDropped(java.io.File[] files ) {
               for(int i = 0; i < files.length; i++) {
                   digestFiles(files[i]);
               }
           }
        });

        dropPanel.setVisible(true);
        add(dropPanel);
    }


}
