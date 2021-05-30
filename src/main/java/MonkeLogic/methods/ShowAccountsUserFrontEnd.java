package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowAccountsUserFrontEnd implements Initializable {
    //region Variables
    @FXML
    private ListView<String> websites;
    @FXML
    private ListView<String> usernames;
    @FXML
    private ListView<String> passwords;
    private static ObservableList<String> yourWebsites;
    private static ObservableList<String> yourUsernames;
    private static ObservableList<String> yourPasswords;

    //endregion

    //region This happens when the instance is created
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        //addAccountsToTable();
    }

    public ShowAccountsUserFrontEnd() {
        sceneManager = SceneManager.getInstance();

    }
    //endregion


    //Todo: Add Reading And ListView here when latest version is updated.
    //region Adds Accounts to TableView
    private void addAccountsToList() {
        ArrayList<String> tmpWebsites = new ArrayList<>();
        ArrayList<String> tmpUsernames = new ArrayList<>();
        ArrayList<String> tmpPasswords = new ArrayList<>();
    }
    //endregion

    //region Displays Accounts on List

    //endregion

    //region Shows/Hides Elements on Application

    //endregion

}
