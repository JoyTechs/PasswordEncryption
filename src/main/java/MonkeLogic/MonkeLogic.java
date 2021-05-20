package MonkeLogic;

import MonkeLogic.controllers.FileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonkeLogic extends Application {

    public static void main(String[] args) {
        FileManager.init();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MonkeLogic");
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
