package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.SecurityQuestion;
import MonkeLogic.frontEnd.AnswerSecurityQuestionFrontEnd;

public class AnswerSecurityQuestionBackEnd {
    private static AnswerSecurityQuestionFrontEnd answerSecurityQuestionFrontEnd;
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

    public static void setInstance() {
        instance = null;
    }
    //endregion

    public static void checkAnswer(SecurityQuestion securityQuestion, AnswerSecurityQuestionFrontEnd frontEnd) {
        answerSecurityQuestionFrontEnd = frontEnd;
        if (ReadFromDB.getSecurityQuestion(securityQuestion) == true) {
            SceneManager.getInstance().resetPassword();
        } else {
            //TODO: add Something to else
        }
    }
}