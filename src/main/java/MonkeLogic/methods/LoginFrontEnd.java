package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.w3c.dom.events.Event;

public class LoginFrontEnd {

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

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    @FXML
    public void loginAttempt(ActionEvent e) throws Exception
    {

        username = usernameInpt.getText();
        password = passwordInpt.getText();

        if (!username.equals("") && ! password.equals(""))
        {

        }
        else
        {
            //Display Message
        }

    }

}
