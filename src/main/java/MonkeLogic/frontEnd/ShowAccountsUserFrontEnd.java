package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.ShowAccountsUserBackEnd;
import MonkeLogic.controllers.SceneManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private TableColumn usernameCol;
    @FXML
    private TableColumn password;
    @FXML
    private Button goBack;
    @FXML
    private Button editAccount;
    @FXML
    private Button search;
    @FXML
    private Button createAccount;

    //TODO: Add List from active user
    private static ObservableList<Account> accountObservableLists;
    //endregion

    //region This happens when the instance is created
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        loadAccounts();
    }
    //endregion

    //region Adds Accounts to TableView
    public void loadAccounts() {
        setAccountObservableLists();
        accountsTable.setEditable(true);
        websiteCol.setCellValueFactory(new PropertyValueFactory<>("website"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        accountsTable.setItems(accountObservableLists);
        accountsTable.setEditable(false);
    }

    public void setAccountObservableLists() {
        accountObservableLists = FXCollections.observableArrayList(ReadFromDB.getAccountsUser());
    }
    //endregion

    @FXML
    public void editChosenAccount(ActionEvent e) {
        sceneManager.editAccountInfo();
    }

    @FXML
    public void logout(ActionEvent e) {
        new ShowAccountsUserBackEnd();
    }

    @FXML
    public void createAccount(ActionEvent e) {
        sceneManager.createAccount();
    }

    @FXML
    public void search() {

    }


}
