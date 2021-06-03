package MonkeLogic.frontEnd;

import MonkeLogic.controllers.ChosenAccountForEdit;
import MonkeLogic.controllers.SceneManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.Account;
import MonkeLogic.methods.Logout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
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
    @FXML
    private Button goBack;
    @FXML
    private Button editAccount;
    @FXML
    private TextField searchInpt;
    @FXML
    private Button searchBtn;
    @FXML
    private Button createAccount;
    @FXML
    private Button createUser;
    @FXML
    private Label editWarning;

    private static ObservableList<Account> accountObservableLists;
    private static ArrayList<Account> allAccounts;
    private static ArrayList<Account> searchResults;

    // endregion

    //region This happens on init
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        editWarning.setVisible(false);
        loadAccounts();
    }
    //endregion

    //region Methods
    public void loadAccounts() {
        accountsTable.setPlaceholder(new Label("No Accounts Found"));
        setAccountObservableLists(setAllAccountsList());

    }

    public ArrayList<Account> setAllAccountsList() {
        allAccounts = ReadFromDB.getAccountsAdmin();
        return allAccounts;
    }

    public void setSearchResults() {
        setAccountObservableLists(searchResults);
    }

    public void setAccountObservableLists(ArrayList<Account> activeList) {
        accountObservableLists = FXCollections.observableArrayList(activeList);
        accountsTable.setEditable(true);
        websiteCol.setCellValueFactory(new PropertyValueFactory<>("website"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("employee"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        accountsTable.setItems(accountObservableLists);
        accountsTable.setEditable(false);
    }

    private void NoSearchResults() {
        accountsTable.setPlaceholder(new Label("No Search Results"));
        accountsTable.setItems(null);
    }
    //endregion

    //region FXML Methods
    @FXML
    public void search(ActionEvent e) {

        ArrayList<Account> temp = new ArrayList<>();

        if (!searchInpt.getText().equals("") || !searchInpt.getText().contains(" ")) {
            for (Account account : allAccounts) {
                if (account.getWebsite().equals(searchInpt.getText())) {
                    temp.add(account);
                    System.out.println("added " + account);
                }
            }
            if (temp.size() <= 0) {
                System.out.println("No Search Results");
                NoSearchResults();
            } else {
                searchResults = temp;
                setSearchResults();
            }

        }

    }

    @FXML
    public void logout(ActionEvent e) {
        Logout.logoutUser();
    }

    @FXML
    public void createUser(ActionEvent e) {
        sceneManager.createUser();
    }

    @FXML
    public void createAccount(ActionEvent e) {
        sceneManager.createAccount();
    }

    @FXML
    public void editChosenAccount(ActionEvent e) throws Exception {
        if (accountsTable.getSelectionModel().isEmpty()) {
            editWarning.setVisible(true);
        } else {
            editWarning.setVisible(false);
            ChosenAccountForEdit.setChosenAccount(accountObservableLists.get(accountsTable.getSelectionModel().getSelectedIndex()));
            sceneManager.editAccountInfo();
        }
    }
    //endregion

}