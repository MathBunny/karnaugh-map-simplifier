/**
 * @author Horatiu Lazu
 */

import javafx.scene.control.Tab;
import javafx.event.ActionEvent;

public class FrameController {
    private Tab [] tabs = new Tab [5];
    public Tab twoVariables;
    public Tab threeVariables;
    public Tab fourVariables;

    public FrameController(){
        tabs[0] = twoVariables;
        tabs[1] = threeVariables;
        tabs[2] = fourVariables;
    }

    public void aboutMenuItemPressed(ActionEvent e){
        new About();
    }

    public void exitMenuItemPressed(ActionEvent e){
        System.exit(0);
    }
}
