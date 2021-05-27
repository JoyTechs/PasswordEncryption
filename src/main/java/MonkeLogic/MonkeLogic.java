package MonkeLogic;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.methods.LoginFrontEnd;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MonkeLogic extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MonkeLogic");

        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        //LoginFrontEnd loginFrontEnd = new LoginFrontEnd();


        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/MonkeLogic/Login.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.setPrimaryStage(primaryStage);
        sceneManager.setScene(scene);
        primaryStage.show();

        /*
        primaryStage.setScene(scene);
        primaryStage.show();
        */
    }

}
