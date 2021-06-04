package MonkeLogic.frontEnd;

import MonkeLogic.backEnd.AnswerSecurityQuestionBackEnd;
import MonkeLogic.controllers.SceneManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.SecurityQuestion;
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

    private String username;
    private int question;
    private String answer;

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

        username = usernameInpt.getText();
        question = usersQuestion.getSelectionModel().getSelectedIndex();
        answer = usersAnswer.getText();
        AnswerSecurityQuestionBackEnd.checkAnswer(new SecurityQuestion(Integer.parseInt(ReadFromDB.getUserIDfromUsername(username)), question, answer));

    }
}