package MonkeLogic;

import MonkeLogic.controllers.SceneManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MonkeLogic extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    //This Starts the Window Application
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MonkeLogic");
        Scene scene = new Scene(new AnchorPane());
        primaryStage.setScene(scene);
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.setPrimaryStage(primaryStage);
        sceneManager.setScene(scene);
        sceneManager.login();
    }
}
