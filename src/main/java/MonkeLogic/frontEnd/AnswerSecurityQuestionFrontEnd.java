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
import javafx.scene.control.Label;
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
    @FXML
    private Label wrongUsername;
    @FXML
    private Label wrongQuestion;
    @FXML
    private Label wrongAnswer;
    @FXML
    private Label nullUsername;
    @FXML
    private Label nullQuestion;
    @FXML
    private Label nullAnswer;


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
        setAllErrorMessages(false);
    }

    private void setSecurityQuestionsListView() {
        usersQuestion.setItems(securityQuestions);
    }
    //endregion

    @FXML
    public void submitAnswer(ActionEvent e) throws Exception {

        //TODO: implement Checks for Null.
        question = usersQuestion.getSelectionModel().getSelectedIndex();
        username = usernameInpt.getText();
        answer = usersAnswer.getText();

        if (noErrors() == true) {
            setAllErrorMessages(false);
            AnswerSecurityQuestionBackEnd.checkAnswer(new SecurityQuestion(ReadFromDB.getUserIDFromUsername(username), question, answer), this);
        } else {
            setNullUsername(checkIfNull(username));
            setNullQuestion(checkIfNull(String.valueOf(question)));
            setNullAnswer(checkIfNull(answer));
        }
    }

    private Boolean noErrors() {
        return !checkIfNull(username) && !checkIfNull(answer) && !checkIfNull(String.valueOf(question));
    }

    private Boolean checkIfNull(String string) {
        return string.equals("");
    }

    private void setNullUsername(Boolean show) {
        nullUsername.setVisible(show);
    }

    private void setNullQuestion(Boolean show) {
        nullQuestion.setVisible(show);
    }

    private void setNullAnswer(Boolean show) {
        nullAnswer.setVisible(show);
    }

    public void setWrongAnswer(Boolean show) {
        wrongAnswer.setVisible(show);
    }

    public void setWrongUsername(Boolean show) {
        wrongUsername.setVisible(show);
    }

    public void setWrongQuestion(Boolean show) {
        wrongQuestion.setVisible(show);
    }

    private void setAllErrorMessages(Boolean show) {

        setNullAnswer(show);
        setNullUsername(show);
        setNullQuestion(show);
        setWrongAnswer(show);
        setWrongQuestion(show);
        setWrongUsername(show);
    }

}