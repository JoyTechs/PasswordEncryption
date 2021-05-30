package MonkeLogic.frontEnd;

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
        wrongUsername.setVisible(false);
        wrongPassword.setVisible(false);
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
    private Label wrongUsername;
    @FXML
    private Label wrongPassword;
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
    public void loginAttempt(ActionEvent e) throws Exception {

        username = usernameInpt.getText();
        password = passwordInpt.getText();

        if (isStringNull(username) || isStringNull(password)) {
            setWrongUsername(isStringNull(username));
            setWrongPassword(isStringNull(password));

        } else if (!isStringNull(username) && !isStringNull(password)) {
            new LoginBackEnd(username, password);
        }

    }
    //endregion

    //region This Checks if Input is Null
    private Boolean isStringNull(String str) {

        return str.equals("");
    }
    //endregion

    //region Shows/Hides Text on Application
    public void setWrongUsername(Boolean show) {
        wrongUsername.setVisible(show);
    }

    public void setWrongPassword(Boolean show) {
        wrongPassword.setVisible(show);
    }
    //endregion


}
