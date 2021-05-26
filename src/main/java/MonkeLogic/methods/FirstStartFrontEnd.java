package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FirstStartFrontEnd
{
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextArea textArea1;
    @FXML
    private Button button1;
    @FXML
    private TextField textfield1;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private PasswordField passwordField1;

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
