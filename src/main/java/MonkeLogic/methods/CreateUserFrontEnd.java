package MonkeLogic.methods;

import MonkeLogic.backEnd.CreateUserBackEnd;
import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateUserFrontEnd {

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

    private Boolean isStringNull(String str) {

        return str.equals("");
    }

}