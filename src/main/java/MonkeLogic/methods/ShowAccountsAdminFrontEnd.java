package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAccountsAdminFrontEnd implements Initializable {

    //region This is the Lists Variables
    @FXML
    private HBox listsHBox;
    @FXML
    private final ListView<String> websites = new ListView<>();
    @FXML
    private final ListView<String> users = new ListView<>();
    @FXML
    private final ListView<String> usernames = new ListView<>();
    //endregion

    //region
    @FXML
    private TableView accounts;

    //endregion

    //region This happens on init
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
    }
    //endregion

    private void loadAccounts() {


    }
}
