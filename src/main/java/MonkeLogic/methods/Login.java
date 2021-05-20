package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    //region Variables
    @FXML
    private Button login;
    @FXML
    private TextField usernameInpt;
    @FXML
    private PasswordField passwordInpt;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label passwordLabel;

    private String username;
    private String password;
    private Boolean usernameNull;
    private Boolean passwordNull;
    //endregion

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


}
