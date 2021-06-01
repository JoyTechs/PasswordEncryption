package MonkeLogic.frontEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.dbo.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAccountsAdminFrontEnd implements Initializable {


    //region TableView Variables
    @FXML
    private TableView accountsTable;
    @FXML
    private TableColumn websiteCol;
    @FXML
    private TableColumn userCol;
    @FXML
    private TableColumn usernameCol;
    @FXML
    private TableColumn password;

    private static final ObservableList<Account> accountObservableLists = FXCollections.observableArrayList(
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

    //region This happens on init
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        loadAccounts();
    }
    //endregion

    public void loadAccounts() {
        accountsTable.setEditable(true);
        websiteCol.setCellValueFactory(new PropertyValueFactory<>("website"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        accountsTable.setItems(accountObservableLists);
        accountsTable.setEditable(false);
    }

    @FXML
    public void editChosenAccount(ActionEvent e) {
        sceneManager.editAccountInfo();
    }
}
