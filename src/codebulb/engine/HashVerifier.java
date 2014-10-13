package codebulb.engine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Lemmens on 6-10-2014.
 */
public class HashVerifier extends Component {

    public HashVerifier() {

    }

    public boolean compare(String twee, String een) {
        System.out.println(een);
        System.out.println(twee);
        if(twee.equals(een)){
            System.out.println("Matched");
            return true;
        } else{
            System.out.println("Geen match");
            return false;
        }
    }

    // stuff  stuff stuff merge test
}
