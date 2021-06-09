package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.FirstStartBackEnd;
import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstStartFrontEnd implements Initializable {

    //region Variables
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label instructionLabel;
    @FXML
    private Button createAccount;
    @FXML
    private TextField usernameInpt;
    @FXML
    private PasswordField passwordInpt;
    @FXML
    private TextField passwordInptVisible;
    @FXML
    private CheckBox showPassword;
    @FXML
    private Label shortUsername;
    @FXML
    private Label shortPassword;
    @FXML
    private Label invalidUsernameCharacter;
    @FXML
    private Label invalidPasswordCharacter;

    private String username;
    private String password;
    private SceneManager sceneManager;
    //endregion

    //region This happens when the instance is created
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        //This Binds the TextField and PasswordField to the Checkbox
        //But Makes them Opposites so that only one is active at a time.
        passwordInptVisible.managedProperty().bind(showPassword.selectedProperty());
        passwordInpt.managedProperty().bind(showPassword.selectedProperty().not());
        //This Binds the Text in the TextField and PasswordField to each other
        //So that they will always contain the same text.
        passwordInptVisible.textProperty().bindBidirectional(passwordInpt.textProperty());
        shortUsername.setVisible(false);
        shortPassword.setVisible(false);
        invalidUsernameCharacter.setVisible(false);
        invalidPasswordCharacter.setVisible(false);
    }
    //endregion

    //region This Verifies User Credentials
    @FXML
    public void createAdminAccount(ActionEvent e) {
        setAllErrorVisibilities();
        username = usernameInpt.getText();
        password = passwordInpt.getText();

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
            FirstStartBackEnd.addAdmin(username, password);
        }
    }
    //endregion

    //region These Checks if Inputs are Correct
    private Boolean doesStringContainSpaces(String str) {
        return str.contains(" ");
    }

    private Boolean isStringToShort(String strLength, int minLength) {
        return strLength.length() <= minLength;
    }
    //endregion

    //region Shows/Hides Elements on Application
    public void setShortUsernameVisibility(Boolean show) {
        shortUsername.setVisible(show);
    }

    public void setShortPasswordVisibility(Boolean show) {
        shortPassword.setVisible(show);
    }

    public void setInvalidUsernameVisibility(Boolean show) {
        invalidUsernameCharacter.setVisible(show);
    }

    public void setInvalidPasswordVisibility(Boolean show) {
        invalidPasswordCharacter.setVisible(show);
    }

    public void setAllErrorVisibilities() {

        setShortUsernameVisibility(false);
        setShortPasswordVisibility(false);
        setInvalidUsernameVisibility(false);
        setInvalidPasswordVisibility(false);
    }

    public Boolean noErrors() {
        return !shortUsername.isVisible()
                && !shortPassword.isVisible()
                && !invalidUsernameCharacter.isVisible()
                && !invalidPasswordCharacter.isVisible();
    }

    @FXML
    public void setPasswordVisibility(ActionEvent e) {
        passwordInptVisible.visibleProperty().bind(showPassword.selectedProperty());
        passwordInpt.visibleProperty().bind(showPassword.selectedProperty().not());
    }
    //endregion
}
