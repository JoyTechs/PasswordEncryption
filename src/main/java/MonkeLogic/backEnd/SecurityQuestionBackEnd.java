package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.databasemethods.DBInsert;
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
        DBInsert.saveSecurityQuestion(securityQuestion);
        SessionManager.getActiveUser().setHasSecurityQuestion(true);
        if (SessionManager.getActiveUser().getClearanceLevel().equals("Admin")) {
            SceneManager.getInstance().showAccountsAdmin();
        } else if (SessionManager.getActiveUser().getClearanceLevel().equals("User")) {
            SceneManager.getInstance().showAccountsUser();
        }
    }
}
