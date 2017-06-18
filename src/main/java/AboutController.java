/**
 * @author Horatiu Lazu
 */

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

public class AboutController {
    public Button okButton;

    public void visitWebsiteButtonPress(ActionEvent e){
        openWebpage("http://github.com/MathBunny/karnaugh-map-simplifier");
    }

    public void visitPersonalWebsiteButtonPress(ActionEvent e){
        openWebpage("http://horatiulazu.ca");
    }

    public void okButtonPress(ActionEvent e){
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    public void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
