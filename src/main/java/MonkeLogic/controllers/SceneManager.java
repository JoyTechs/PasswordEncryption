/**
 * Author: Jakob Lundberg
 */
package MonkeLogic.controllers;

import MonkeLogic.methods.MemesFrontEnd;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SceneManager {

    //region Variables
    private static SceneManager instance;
    private Scene scene;
    private Stage primaryStage;
    //endregion

    //region Creates A Singleton SceneManager
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    private SceneManager() {
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    //endregion

    //region Scene Calling Methods
    public void login(){loginScene();}

    public void createUser(){createUserScene();}

    public void firstStart() {
        firstStartScene();
    }

    public void settings(){settingsScene();}

    public void createAccount(){createAccountScene();}

    public void editAccountInfo(){editAccountInfoScene();}

    public void showAccounts(){showAccountsScene();}

    public void memes(){memesScene();}
    //endregion

    //region Methods That Changes the Scenes
    private void loginScene(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/Login.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUserScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/CreateUser.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void firstStartScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/FirstStart.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void settingsScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/Settings.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAccountScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/CreateAccount.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editAccountInfoScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/EditAccountInfo.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAccountsScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/ShowAccounts.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void memesScene() {
        try {
            MemesFrontEnd memesFrontEnd = new MemesFrontEnd();
            File meme = memesFrontEnd.getMemed();
            Media media = new Media(meme.toURI().toURL().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.fitWidthProperty().bind(primaryStage.widthProperty());
            mediaView.fitHeightProperty().bind(primaryStage.heightProperty());
            mediaPlayer.setVolume(0.2);
            scene = new Scene(new AnchorPane(mediaView));
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
            primaryStage.show();
            mediaPlayer.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion

}