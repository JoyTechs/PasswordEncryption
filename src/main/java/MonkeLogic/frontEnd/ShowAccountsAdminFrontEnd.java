package MonkeLogic.frontEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.Account;
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

    private static ObservableList<Account> accountObservableLists;


    // endregion

    //region This happens on init
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        loadAccounts();
    }
    //endregion

    public void loadAccounts() {
        setAccountObservableLists();
        accountsTable.setEditable(true);
        websiteCol.setCellValueFactory(new PropertyValueFactory<>("website"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("employee"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        accountsTable.setItems(accountObservableLists);
        accountsTable.setEditable(false);
    }

    public void setAccountObservableLists() {
        accountObservableLists = FXCollections.observableArrayList(ReadFromDB.getAccountsAdmin());
    }

    @FXML
    public void editChosenAccount(ActionEvent e) {
        sceneManager.editAccountInfo();
    }
}
