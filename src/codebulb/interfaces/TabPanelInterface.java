package codebulb.interfaces;

import java.awt.*;

/**
 * Created by Robert on 18-1-2015.
 */
// make sure the tabs work the same so the interaction with the controllers is the same.
public interface TabPanelInterface {

    public void update();

    public void notifyController();

    public Color getBackgroundColor();


}
