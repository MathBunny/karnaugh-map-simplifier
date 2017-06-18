/**
 * @author Horatiu Lazu
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class About extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public About(){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/about.fxml"));

            Scene scene = new Scene(root, 500, 150);
            stage.setTitle("About Karnaugh Map Simplifier");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){}
    }

    @Override
    public void start(Stage stage) throws Exception {
    }
}
