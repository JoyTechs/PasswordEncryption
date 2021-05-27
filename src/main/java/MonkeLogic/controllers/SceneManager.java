package MonkeLogic.controllers;

import MonkeLogic.methods.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class SceneManager
{

    private final Scene scene;
    private static String userID;
    private static String userClearanceLevel;

    public void setActiveUser(String userID, String userClearanceLevel) {
        System.out.println(SceneManager.userID + " UserId " + SceneManager.userClearanceLevel + " UserClearanceLevel");
        SceneManager.userID = userID;
        System.out.println(SceneManager.userID + " UserId ");
        SceneManager.userClearanceLevel = userClearanceLevel;
        System.out.println(SceneManager.userClearanceLevel + " UserClearanceLevel");
    }

    public SceneManager(Scene scene) {
        this.scene = scene;
    }

    public void login(){loginScene();}
    public void createUser(){createUserScene();}
    public void setAdmin(){setAdminScene();}
    public void settings(){settingsScene();}
    public void createAccount(){createAccountScene();}
    public void editAccountInfo(){editAccountInfoScene();}
    public void showAccounts(){showAccountsScene();}
    public void memes(){memesScene();}
    public void play(File media) throws MalformedURLException {playMedia(media);}

    private void loginScene(){
        try {
            System.out.println("Working");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            LoginFrontEnd controller = loader.getController();
            controller.setSceneManager(this);
            scene.setRoot(loader.load());

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void createUserScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
            scene.setRoot(loader.load());
            CreateUserFrontEnd controller = loader.getController();
            controller.setSceneManager(this);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void setAdminScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
            scene.setRoot(loader.load());
            CreateUserFrontEnd controller = loader.getController();
            controller.setSceneManager(this);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void settingsScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
            scene.setRoot(loader.load());
            SettingsFrontEnd controller = loader.getController();
            controller.setSceneManager(this);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void createAccountScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccount.fxml"));
            scene.setRoot(loader.load());
            CreateAccountFrontEnd controller = loader.getController();
            controller.setSceneManager(this);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void editAccountInfoScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditAccountInfo.fxml"));
            scene.setRoot(loader.load());
            EditAccountInfoFrontEnd controller = loader.getController();
            controller.setSceneManager(this);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void showAccountsScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowAccounts.fxml"));
            scene.setRoot(loader.load());
            ShowAccountsFrontEnd controller = loader.getController();
            controller.setSceneManager(this);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void memesScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowAccounts.fxml"));
            scene.setRoot(loader.load());
            ShowAccountsFrontEnd controller = loader.getController();
            controller.setSceneManager(this);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void playMedia(File mediaFile) throws MalformedURLException
    {
        Media media = new Media(mediaFile.toURI().toURL().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        MediaView mediaView = new MediaView(mediaPlayer);

        Scene scene = new Scene(new Pane(mediaView), 1024,800);
        mediaPlayer.play();

    }

}