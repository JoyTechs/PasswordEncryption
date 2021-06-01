package MonkeLogic.frontEnd;
git
import MonkeLogic.backEnd.LoginBackEnd;
import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFrontEnd implements Initializable {

    //region This happens when the instance is created
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        wrongLogin.setVisible(false);
    }
    //endregion

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
    @FXML
    private Label wrongLogin;
    @FXML
    private Text text1;

    private String username;
    private String password;
    //endregion

    //region This Sets the Scene Manager
    private SceneManager sceneManager;

    public LoginFrontEnd() {
        sceneManager = SceneManager.getInstance();
    }
    //endregion

    //region This Verifies User Credentials
    @FXML
    public void loginAttempt(ActionEvent e) {
        username = usernameInpt.getText();
        password = passwordInpt.getText();

        if (isStringNull(username) || isStringNull(password)) {
            setWrongLogin(true);
        } else if (!isStringNull(username) && !isStringNull(password)) {
            new LoginBackEnd(username, password, this);
        }
    }
    //endregion

    //region This Checks if Input is Null
    private Boolean isStringNull(String str) {
        return str.equals("");
    }
    //endregion

    //region Shows/Hides Text on Application
    public void setWrongLogin(Boolean show) {
        wrongLogin.setVisible(show);
    }
    //endregion
}
