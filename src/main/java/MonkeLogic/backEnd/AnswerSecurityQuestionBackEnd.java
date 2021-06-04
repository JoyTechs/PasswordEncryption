package MonkeLogic.backEnd;

import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.SecurityQuestion;

public class AnswerSecurityQuestionBackEnd {
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

    public static void checkAnswer(SecurityQuestion securityQuestion) {
        if (ReadFromDB.getSecurityQuestion(securityQuestion) == true) {
            //TODO: implement password Reset Scene.
        }
    }
}
