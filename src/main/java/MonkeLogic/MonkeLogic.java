package MonkeLogic;

import MonkeLogic.controllers.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MonkeLogic extends Application {

    private Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MonkeLogic");
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public void setStageTitle(String newTitle) {
        stage.setTitle(newTitle);
    }
}
