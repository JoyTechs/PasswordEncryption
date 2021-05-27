package MonkeLogic.methods;

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
    private Boolean usernameNull;
    private Boolean passwordNull;
    //endregion

    private SceneManager sceneManager;
    public LoginFrontEnd ()
    {
        sceneManager = SceneManager.getInstance();
    }

    @FXML
    public void loginAttempt(ActionEvent e) throws Exception
    {

        username = usernameInpt.getText();
        password = passwordInpt.getText();

        if (!username.equals("") && ! password.equals(""))
        {
            sceneManager.createAccount();
            //new LoginBackEnd(username, password, sceneManager);
        }
        else
        {
            //Display Message
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
    }
}
