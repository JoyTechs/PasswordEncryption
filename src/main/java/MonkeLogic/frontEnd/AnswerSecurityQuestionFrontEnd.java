package MonkeLogic.frontEnd;

import MonkeLogic.controllers.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AnswerSecurityQuestionFrontEnd implements Initializable {

    @FXML
    private ChoiceBox<String> usersQuestion;
    @FXML
    private TextField usernameInpt;
    @FXML
    private TextField usersAnswer;
    @FXML
    private Button submitAnswer;

    private final ObservableList<String> securityQuestions = FXCollections.observableArrayList("Where were you born?", "What was your first car?", "Where did you go to Middle School?");

    //region Sets SceneManager on Init
    private SceneManager sceneManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneManager = SceneManager.getInstance();
        setSecurityQuestionsListView();
    }

    private void setSecurityQuestionsListView() {
        usersQuestion.setItems(securityQuestions);
    }
    //endregion

    @FXML
    public void submitAnswer(ActionEvent e) throws Exception {

    }
}