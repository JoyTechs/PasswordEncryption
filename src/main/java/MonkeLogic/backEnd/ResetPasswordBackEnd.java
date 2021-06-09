package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.databasemethods.DBUpdate;

public class ResetPasswordBackEnd {

    //region Singleton
    private static ResetPasswordBackEnd instance;

    public static ResetPasswordBackEnd getInstance() {
        if (instance == null) {
            instance = new ResetPasswordBackEnd();

        }
        return instance;
    }

    private ResetPasswordBackEnd() {
    }
    //endregion

    public static void setNewPassword(String newPassword) {
        DBUpdate.updatePassword(newPassword);
        SessionManager.setActiveUser(null);
        SceneManager.getInstance().login();
    }
}
