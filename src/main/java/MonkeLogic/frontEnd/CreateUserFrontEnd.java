package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.CreateUserBackEnd;
import MonkeLogic.controllers.SceneManager;
import MonkeLogic.dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateUserFrontEnd {

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


    private String username;
    private String password;
    private Boolean isUsernameNull;
    private Boolean isPasswordNull;
    //endregion

    private final SceneManager sceneManager;

    public CreateUserFrontEnd() {
        sceneManager = SceneManager.getInstance();
    }

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
            new CreateUserBackEnd(username, password);
        }
    }

    @FXML
    public void goBack(ActionEvent e) throws Exception {
        sceneManager.showAccountsAdmin();
    }

    private Boolean isStringNull(String str) {
        return str.equals("");
    }

    @FXML
    public void setPasswordVisibility(ActionEvent e) {
        //This Binds the TextField and PasswordField to the Checkbox
        //But Makes them Opposites so that only one is active at a time.
        passwordInptVisible.managedProperty().bind(showPassword.selectedProperty());
        passwordInptVisible.visibleProperty().bind(showPassword.selectedProperty());
        passwordInpt.managedProperty().bind(showPassword.selectedProperty().not());
        passwordInpt.visibleProperty().bind(showPassword.selectedProperty().not());

        //This Binds the Text in the TextField and PasswordField to each other
        //So that they will always contain the same text.
        passwordInptVisible.textProperty().bindBidirectional(passwordInpt.textProperty());
    }

}