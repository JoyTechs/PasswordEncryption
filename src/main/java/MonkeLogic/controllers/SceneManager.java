/**
 * Author: Jakob Lundberg
 */
package MonkeLogic.controllers;

import MonkeLogic.frontEnd.MemesFrontEnd;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class SceneManager {

    //region Variables
    private static SceneManager instance;
    private Scene scene;
    private Scene memeScene;
    private Stage primaryStage;
    //endregion

    //region Creates A Singleton SceneManager
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public static void setInstance() {
        instance = null;
    }

    private SceneManager() {
    }


    //endregion

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

    public void setSecurityQuestion() {
        setSecurityQuestionScene();
    }

    public void answerSecurityQuestion() {
        answerSecurityQuestionScene();
    }

    public void resetPassword() {
        resetPasswordScene();
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

    private void setSecurityQuestionScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/SetSecurityQuestion.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void answerSecurityQuestionScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/AnswerSecurityQuestion.fxml"));
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
            mediaPlayer.setVolume(0.3);
            if (SessionManager.getIsThisElias()) {
                mediaPlayer.setStopTime(Duration.INDEFINITE);
            } else {
                mediaPlayer.setStopTime(Duration.seconds(30));
            }
            System.out.println(mediaPlayer.getStopTime());
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaView.setVisible(false);
                primaryStage.setFullScreen(false);
                SessionManager.setIsThisElias(false);
                answerSecurityQuestion();
            });
            memeScene = new Scene(new AnchorPane(mediaView));
            primaryStage.setScene(memeScene);
            primaryStage.setFullScreen(true);
            primaryStage.show();
            mediaPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetPasswordScene() {
        try {
            System.out.println("Reset Password");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MonkeLogic/ResetPassword.fxml"));
            scene.setRoot(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion

}