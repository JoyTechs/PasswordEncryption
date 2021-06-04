package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.CreateUserBackEnd;
import MonkeLogic.controllers.SceneManager;
import MonkeLogic.dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserFrontEnd implements Initializable {

    //region Variables
    @FXML
    private Button login;
    @FXML
    private Button goBack;
    @FXML
    private CheckBox showPassword;
    @FXML
    private Label showPasswordLabel;
    @FXML
    private TextField usernameInpt;
    @FXML
    private PasswordField passwordInpt;
    @FXML
    private TextField passwordInptVisible;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private CheckBox clearanceLevelCheckBox;


    private String username;
    private String password;
    private String clearanceLevelString = "User";
    private Boolean isUsernameNull;
    private Boolean isPasswordNull;
    //endregion

    //region Sets SceneManager on Init
    private SceneManager sceneManager;
    private static CreateUserBackEnd createUserBackEnd = CreateUserBackEnd.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sceneManager = SceneManager.getInstance();
        //This Binds the TextField and PasswordField to the Checkbox
        //But Makes them Opposites so that only one is active at a time.
        passwordInptVisible.managedProperty().bind(showPassword.selectedProperty());
        passwordInpt.managedProperty().bind(showPassword.selectedProperty().not());
        //This Binds the Text in the TextField and PasswordField to each other
        //So that they will always contain the same text.
        passwordInptVisible.textProperty().bindBidirectional(passwordInpt.textProperty());
    }
    //endregion

    //region FXML Methods
    @FXML
    public void createUser(ActionEvent e) throws Exception {
        username = usernameInpt.getText();
        password = passwordInpt.getText();

        if (isStringNull(username) || isStringNull(password)) {
            if (isStringNull(username)) {
                isUsernameNull = true;
            }
            if (isStringNull(password)) {
                isPasswordNull = true;
            }
            sceneManager.createAccount();
        } else if (!isStringNull(username) && !isStringNull(password)) {
            createUserBackEnd.createNewUser(new User(username, password, clearanceLevelString));
        }
    }

    @FXML
    public void goBack(ActionEvent e) throws Exception {
        sceneManager.showAccountsAdmin();
    }


    @FXML
    public void setPasswordVisibility(ActionEvent e) {
        passwordInptVisible.visibleProperty().bind(showPassword.selectedProperty());
        passwordInpt.visibleProperty().bind(showPassword.selectedProperty().not());
    }

    @FXML
    public void setClearanceLevelCheckBox() {
        if (clearanceLevelCheckBox.isSelected()) {
            clearanceLevelString = "Admin";
        } else {
            clearanceLevelString = "User";
        }
    }
    //endregion

    //Checks if String is null and returns a Boolean.
    private Boolean isStringNull(String str) {
        return str.equals("");
    }

}