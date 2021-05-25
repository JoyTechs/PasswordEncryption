package MonkeLogic;

import MonkeLogic.controllers.FileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonkeLogic extends Application {

    private Stage stage;
    public static void main(String[] args) {
        FileManager.init();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("MonkeLogic");
        primaryStage.show();
    }

    public void setStageTitle(String newTitle) {
        stage.setTitle(newTitle);
    }
}
