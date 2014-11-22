package codebulb.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robert Lemmens on 21-11-2014.
 */
public class TrackingControls extends JPanel implements ActionListener{

    JButton select;
    JButton checkMD5;

    public TrackingControls() {
        setBackground(Color.red);
        select = new JButton("Select folder");
        select.addActionListener(this);
        checkMD5 = new JButton("Check md5");
        checkMD5.addActionListener(this);

        add(select);
        add(checkMD5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(select)) {
            //doiets
        }
        if(e.getSource().equals(checkMD5)) {
            // doiets
        }
    }
}
