package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.CreateAccountBackEnd;
import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountFrontEnd implements Initializable {

    @FXML
    private Label websiteLabel;
    @FXML
    private TextField websiteInpt;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label usernameToShort;
    @FXML
    private Label invalidCharacterUsername;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label passwordToShort;
    @FXML
    private Label invalidCharacterPassword;
    @FXML
    private Label websiteToShort;
    @FXML
    private Label invalidCharacterWebsite;
    @FXML
    private Label showPasswordLabel;
    @FXML
    private Button createAccount;
    @FXML
    private Button goBack;
    @FXML
    private TextField usernameInpt;
    @FXML
    private PasswordField passwordInpt;
    @FXML
    private TextField passwordInptTextField;
    @FXML
    private CheckBox showPassword;


    private String website;
    private String username;
    private String password;
    private static final CreateAccountBackEnd createAccountBackEnd = CreateAccountBackEnd.getInstance();

    //region Sets SceneManager on Init
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
    }
    //endregion

    @FXML
    public void createAccount(ActionEvent e) {
        setAllErrorVisibilities();
        website = websiteInpt.getText();
        username = usernameInpt.getText();
        password = passwordInpt.getText();


        if (isStringToShort(website, 2)) {
            setShortUsernameVisibility(true);
        } else if (doesStringContainSpaces(website)) {
            setInvalidUsernameVisibility(true);
        }
        if (isStringToShort(username, 2)) {
            setShortUsernameVisibility(true);
        } else if (doesStringContainSpaces(username)) {
            setInvalidUsernameVisibility(true);
        }
        if (isStringToShort(password, 6)) {
            setShortPasswordVisibility(true);
        } else if (doesStringContainSpaces(password)) {
            setInvalidPasswordVisibility(true);
        }
        if (noErrors().equals(true)) {
            createAccountBackEnd.saveAccInfo(new Account(website, username, password));
        }
    }

    @FXML
    public void goBack(ActionEvent e) {
        if (SessionManager.getActiveUserClearanceLevel().equals("Admin")) {
            sceneManager.showAccountsAdmin();
        } else {
            sceneManager.showAccountsUser();
        }
    }


    //region These Checks if Inputs are Correct
    private Boolean doesStringContainSpaces(String str) {
        return str.contains(" ");
    }

    private Boolean isStringToShort(String strLength, int minLength) {
        return strLength.length() <= minLength;
    }
    //endregion

    //region Shows/Hides Elements on Application
    public void setShortWebsiteVisibility(Boolean show) {
        websiteToShort.setVisible(show);
    }

    public void setShortUsernameVisibility(Boolean show) {
        usernameToShort.setVisible(show);
    }

    public void setShortPasswordVisibility(Boolean show) {
        passwordToShort.setVisible(show);
    }

    public void setInvalidWebsiteVisibility(Boolean show) {
        invalidCharacterWebsite.setVisible(show);
    }

    public void setInvalidUsernameVisibility(Boolean show) {
        invalidCharacterUsername.setVisible(show);
    }

    public void setInvalidPasswordVisibility(Boolean show) {
        invalidCharacterPassword.setVisible(show);
    }

    public void setAllErrorVisibilities() {
        setShortWebsiteVisibility(false);
        setShortUsernameVisibility(false);
        setShortPasswordVisibility(false);
        setInvalidWebsiteVisibility(false);
        setInvalidUsernameVisibility(false);
        setInvalidPasswordVisibility(false);
    }

    public Boolean noErrors() {
        return !websiteToShort.isVisible()
                && !usernameToShort.isVisible()
                && !passwordToShort.isVisible()
                && !invalidCharacterWebsite.isVisible()
                && !invalidCharacterUsername.isVisible()
                && !invalidCharacterPassword.isVisible();
    }

    @FXML
    public void setPasswordVisibility(ActionEvent e) {
        //This Binds the TextField and PasswordField to the Checkbox
        //But Makes them Opposites so that only one is active at a time.
        passwordInptTextField.managedProperty().bind(showPassword.selectedProperty());
        passwordInptTextField.visibleProperty().bind(showPassword.selectedProperty());
        passwordInpt.managedProperty().bind(showPassword.selectedProperty().not());
        passwordInpt.visibleProperty().bind(showPassword.selectedProperty().not());

        //This Binds the Text in the TextField and PasswordField to each other
        //So that they will always contain the same text.
        passwordInptTextField.textProperty().bindBidirectional(passwordInpt.textProperty());
    }
    //endregion

}