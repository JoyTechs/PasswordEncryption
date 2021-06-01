package MonkeLogic;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.StartUp;
import MonkeLogic.services.ReadFromDb;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MonkeLogic extends Application {


    public static void main(String[] args) {
        StartUp startUp = new StartUp();
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
        if (ReadFromDb.firstStart()) {
            sceneManager.firstStart();
        } else {
            sceneManager.login();
        }


    }
}
