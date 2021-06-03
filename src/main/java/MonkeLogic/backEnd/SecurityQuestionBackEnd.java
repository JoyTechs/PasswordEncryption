package MonkeLogic.backEnd;

import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.SecurityQuestion;

public class SecurityQuestionBackEnd {

    //region Singleton
    private static SecurityQuestionBackEnd instance;

    public static SecurityQuestionBackEnd getInstance() {
        if (instance == null) {
            instance = new SecurityQuestionBackEnd();
        }
        return instance;
    }

    public SecurityQuestionBackEnd() {

    }
    //endregion


    public static void setUsersSecurityQuestion(String securityAnswer, int selectedIndex) {

        SecurityQuestion securityQuestion = new SecurityQuestion(SessionManager.getActiveUser().getUserID(), selectedIndex, securityAnswer);

    }
}
