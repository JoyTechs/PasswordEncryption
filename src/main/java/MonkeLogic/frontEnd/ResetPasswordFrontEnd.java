package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.ResetPasswordBackEnd;
import MonkeLogic.controllers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ResetPasswordFrontEnd implements Initializable {

    //region Variables
    @FXML
    private TextField inputPassword;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button submitPassword;
    @FXML
    private Label nullPasswordInpt;
    @FXML
    private Label nullPasswordConfirm;
    @FXML
    private Label passwordsNoMatch;

    //endregion

    private String passwordInpt;
    private String passwordConfirm;

    //region Singleton
    private static SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
    }
    //endregion

    @FXML
    public void setPassword(ActionEvent e) throws Exception {
        setAllWarnings(false);
        passwordInpt = inputPassword.getText();
        passwordConfirm = confirmPassword.getText();

        setNullPasswordInpt(isStringNull(passwordInpt));
        setNullPasswordConfirm(isStringNull(passwordConfirm));
        setPasswordsNoMatch(!isStringsSame(passwordInpt, passwordConfirm));

        if (noErrors() == true) {
            setAllWarnings(false);
            ResetPasswordBackEnd.setNewPassword(passwordInpt);
        }

    }

    private Boolean isStringNull(String stringInpt) {
        return stringInpt.equals("");
    }

    private Boolean isStringsSame(String str1, String str2) {
        return str1.equals(str2);
    }

    private void setNullPasswordInpt(Boolean show) {
        nullPasswordInpt.setVisible(show);
    }

    private void setNullPasswordConfirm(Boolean show) {
        nullPasswordConfirm.setVisible(show);
    }

    private void setPasswordsNoMatch(Boolean show) {
        passwordsNoMatch.setVisible(show);
    }

    private Boolean noErrors() {
        return !nullPasswordInpt.isVisible() && !nullPasswordConfirm.isVisible() && !passwordsNoMatch.isVisible();
    }

    private void setAllWarnings(Boolean show) {
        setNullPasswordInpt(show);
        setNullPasswordConfirm(show);
        setPasswordsNoMatch(show);
    }


}
