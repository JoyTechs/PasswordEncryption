package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.SecurityQuestion;
import MonkeLogic.frontEnd.AnswerSecurityQuestionFrontEnd;

public class AnswerSecurityQuestionBackEnd {
    private static AnswerSecurityQuestionFrontEnd answerSecurityQuestionFrontEnd;
    //TODO: add to StartUp
    //region Singleton
    private static AnswerSecurityQuestionBackEnd instance;

    public static AnswerSecurityQuestionBackEnd getInstance() {
        if (instance == null) {
            instance = new AnswerSecurityQuestionBackEnd();

        }
        return instance;
    }

    private AnswerSecurityQuestionBackEnd() {
    }
    //endregion

    public static void checkAnswer(SecurityQuestion securityQuestion, AnswerSecurityQuestionFrontEnd frontEnd) {
        answerSecurityQuestionFrontEnd = frontEnd;
        if (ReadFromDB.getSecurityQuestion(securityQuestion) == true) {
            SceneManager.getInstance().resetPassword();
            //TODO: implement password Reset Scene.
        } else {

        }
    }
}