package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateAccountFrontEnd
{

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private TextField textfield1;
    @FXML
    private TextField textField2;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private PasswordField passwordField1;

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }



}