/**
 * @author Horatiu Lazu
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Frame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/frame.fxml"));

        Scene scene = new Scene(root, 960, 640);

        stage.setTitle("Karnaugh Map Simplification Software");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init(){

    }
}
