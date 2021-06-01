package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.User;

public class FirstStartBackEnd {


    private static FirstStartBackEnd instance;
    private static SceneManager sceneManager;

    private FirstStartBackEnd() {

    }

    public static FirstStartBackEnd getInstance() {
        if (instance == null) {
            instance = new FirstStartBackEnd();

        }
        return instance;
    }

    public static void addAdmin(String username, String password) {
        sceneManager = SceneManager.getInstance();
        User activeUser = ReadFromDB.readFromDbToLoginIn(username, password);
        if (activeUser != null) {
            SessionManager.setActiveUser(activeUser);
            sceneManager.showAccountsAdmin();
        }
    }
}
