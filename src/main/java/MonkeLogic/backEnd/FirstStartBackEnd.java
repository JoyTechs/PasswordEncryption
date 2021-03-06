package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.databasemethods.DBUpdate;
import MonkeLogic.databasemethods.DBSelect;
import MonkeLogic.dto.User;

public class FirstStartBackEnd {


    private static SceneManager sceneManager;

    //region Singleton
    private static FirstStartBackEnd instance;

    private FirstStartBackEnd() {

    }

    public static FirstStartBackEnd getInstance() {
        if (instance == null) {
            instance = new FirstStartBackEnd();
        }
        return instance;
    }
    //endregion

    public static void addAdmin(String username, String password) {
        sceneManager = SceneManager.getInstance();
        DBUpdate.updateUser(new User(username, password));
        User activeUser = DBSelect.readFromDBToLogin(username, password);
        if (activeUser != null) {
            SessionManager.setActiveUser(activeUser);
            sceneManager.setSecurityQuestion();
        }
    }
}
