package MonkeLogic.methods;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.dbo.Account;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowAccountsUserFrontEnd implements Initializable {
    //region Variables
    @FXML
    private TableView accountsTable;
    @FXML
    private TableColumn<Account, String> websiteColumn;
    @FXML
    private TableColumn<Account, String> userNameColumn;
    @FXML
    private TableColumn<Account, String> passwordColumn;
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


    //Todo Work on getting a List of accounts to show up when the user logs in, maybe use Listview instead of tableView.
    //region Adds Accounts to TableView
    /*
    private void addAccountsToTable()
    {
        websiteColumn.setCellValueFactory(new PropertyValueFactory<>("website"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        accountsTable.getColumns().add(websiteColumn);
        accountsTable.getColumns().add(userNameColumn);
        accountsTable.getColumns().add(passwordColumn);
        TempAccounts tempAccounts = new TempAccounts();
        for (Account account: tempAccounts.getTempAccounts())
        {
            accountsTable.getItems().add(new Account(account.getUsername(), account.getPassword(), account.getWebsite()));
        }

    }
    */
    //endregion

    //region Displays Accounts on List

    //endregion

    //region Shows/Hides Elements on Application

    //endregion

}
