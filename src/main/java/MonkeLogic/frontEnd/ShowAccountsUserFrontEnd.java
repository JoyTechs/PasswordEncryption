package MonkeLogic.frontEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.dbo.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAccountsUserFrontEnd implements Initializable {

    //region Variables
    @FXML
    private TableView accountsTable;
    @FXML
    private TableColumn websiteCol;
    @FXML
    private TableColumn userCol;
    @FXML
    private TableColumn usernameCol;
    private final ObservableList<Account> accountObservableLists = FXCollections.observableArrayList(
            new Account(1, 1, "Abdi", "Abdi", "Jag1234", "Google"),
            new Account(2, 2, "Andrej", "Andrej", "Orkar12", "Twitter"),
            new Account(3, 3, "Jakob", "Jakob", "Inte123", "Google"),
            new Account(4, 4, "Isa", "Isa", "Mer1234", "Twitter"),
            new Account(5, 5, "Elias", "Elias", "Idag123", "Baguette"),
            new Account(6, 6, "Penguin", "Penguin", "Vi12345", "Glömde"),
            new Account(7, 7, "Java", "Java", "Tar1234", "Hur"),
            new Account(8, 8, "Alexander", "Alexander", "Helg.12", "Formatteringen"),
            new Account(9, 9, "Marcus", "Marcus", "Vi12345", "Fungerade"),
            new Account(10, 10, "August", "August", "Ses.123", "Här"));
    //endregion

    //region This happens when the instance is created
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        loadAccounts();
    }

    public ShowAccountsUserFrontEnd() {
        sceneManager = SceneManager.getInstance();

    }
    //endregion


    //Todo: Add Reading And ListView here when latest version is updated.
    //region Adds Accounts to TableView
    public void loadAccounts() {

        accountsTable.setEditable(true);
        websiteCol.setCellValueFactory(new PropertyValueFactory<>("website"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("password"));

        accountsTable.setItems(accountObservableLists);

    }
    //endregion

    //region Displays Accounts on List

    //endregion

    //region Shows/Hides Elements on Application

    //endregion

}
