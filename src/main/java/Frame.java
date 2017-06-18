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

        Scene scene = new Scene(root, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

        stage.setTitle(Constants.FRAME_TITLE);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
