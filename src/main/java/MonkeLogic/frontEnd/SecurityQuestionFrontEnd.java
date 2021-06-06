package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.SecurityQuestionBackEnd;
import MonkeLogic.controllers.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SecurityQuestionFrontEnd implements Initializable {

    @FXML
    private ChoiceBox<String> securityQuestionsListView;
    @FXML
    private TextField securityAnswer;
    @FXML
    private Button submitAnswer;
    @FXML
    private Label warning;

    private final ObservableList<String> securityQuestions = FXCollections.observableArrayList(
            "Where were you born?",
            "What was your first car?",
            "Where did you go to Middle School?");

    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        setSecurityQuestionsListView();
    }

    private void setSecurityQuestionsListView() {
        securityQuestionsListView.setItems(securityQuestions);
    }

    @FXML
    public void setUsersSecurityQuestion(ActionEvent e) throws Exception {
        if (securityQuestionsListView.getSelectionModel().isEmpty()) {
            warning.setVisible(true);
        } else {
            warning.setVisible(false);
            SecurityQuestionBackEnd.setUsersSecurityQuestion(securityAnswer.getText(),
                    securityQuestionsListView.getSelectionModel().getSelectedIndex());
        }
    }

}
