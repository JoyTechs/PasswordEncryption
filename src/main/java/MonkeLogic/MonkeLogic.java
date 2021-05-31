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
        //Todo remove the "scenemanager.login();" line when the DB connection is implemented.
        //Todo And Implement an if check to see if it's the first time the application is run.
        sceneManager.showAccountsAdmin();


    }

}
