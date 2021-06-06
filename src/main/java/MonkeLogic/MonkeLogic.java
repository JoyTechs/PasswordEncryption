package MonkeLogic;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.StartUp;
import MonkeLogic.databasemethods.ReadFromDB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MonkeLogic extends Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StartUp startUp = new StartUp();
        launch(args);
    }

    //This Starts the Window Application
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MonkeLogic");
        Scene scene = new Scene(new AnchorPane());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.setPrimaryStage(primaryStage);
        sceneManager.setScene(scene);
        if (ReadFromDB.firstStart()) {
            sceneManager.firstStart();
        } else {
            sceneManager.login();
        }
    }
}
