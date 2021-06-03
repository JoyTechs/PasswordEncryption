package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.LoginBackEnd;
import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFrontEnd implements Initializable {

    //region This happens when the instance is created
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        wrongLogin.setVisible(false);
        //This Binds the TextField and PasswordField to the Checkbox
        //But Makes them Opposites so that only one is active at a time.
        passwordInptVisible.managedProperty().bind(showPassword.selectedProperty());
        passwordInpt.managedProperty().bind(showPassword.selectedProperty().not());
        //This Binds the Text in the TextField and PasswordField to each other
        //So that they will always contain the same text.
        passwordInptVisible.textProperty().bindBidirectional(passwordInpt.textProperty());

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
    private TextField passwordInptVisible;
    @FXML
    private CheckBox showPassword;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label wrongLogin;
    @FXML
    private Text welcomeTxt;

    private String username;
    private String password;
    private SceneManager sceneManager;
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

    @FXML
    public void setPasswordVisibility(ActionEvent e) {

        passwordInptVisible.visibleProperty().bind(showPassword.selectedProperty());
        passwordInpt.visibleProperty().bind(showPassword.selectedProperty().not());


    }
    //endregion
}
