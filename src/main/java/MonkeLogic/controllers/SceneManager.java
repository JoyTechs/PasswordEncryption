/**
 * Author: Jakob Lundberg
 */
package MonkeLogic.controllers;

import MonkeLogic.dto.User;
import MonkeLogic.frontEnd.MemesFrontEnd;
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
    private static User activeUser;
    private Scene scene;
    private Stage primaryStage;
    //endregion

    //Todo: add To StartUp
    //region Creates A Singleton SceneManager
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
    private SceneManager() {
    }

    //region Getters/Setters
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    //endregion

    //endregion

    //region Scene Calling Methods
    public void login() {
        loginScene();
    }

    public void createUser() {
        createUserScene();
    }

    public void firstStart() {
        firstStartScene();
    }

    public void createAccount() {
        createAccountScene();
    }

    public void editAccountInfo() {
        editAccountInfoScene();
    }

    public void showAccountsUser() {
        showAccountsUserScene();
    }

    public void showAccountsAdmin() {
        showAccountsAdminScene();
    }

    public void memes() {
        memesScene();
    }
    //endregion

    //region Methods That Changes the Scenes
    private void loginScene() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/Login.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUserScene() {

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

    private void createAccountScene() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/CreateAccount.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editAccountInfoScene() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/EditAccountInfo.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAccountsUserScene() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/ShowAccountsUser.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAccountsAdminScene() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/ShowAccountsAdmin.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void memesScene() {

        try {
            //TODO: Fix what happens after video is done
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