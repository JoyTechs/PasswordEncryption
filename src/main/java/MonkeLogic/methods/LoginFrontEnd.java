package MonkeLogic.methods;

import MonkeLogic.DbConnection;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFrontEnd implements Initializable {

    //This happens when the instance is created
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
    }

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
    private Text text1;

    private String username;
    private String password;
    private Boolean isUsernameNull;
    private Boolean isPasswordNull;
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
            if (isStringNull(username)) {
                isUsernameNull = true;
            }
            if (isStringNull(password)) {
                isPasswordNull = true;
            }


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


}
