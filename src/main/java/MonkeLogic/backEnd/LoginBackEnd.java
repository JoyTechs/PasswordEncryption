package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.User;
import MonkeLogic.frontEnd.LoginFrontEnd;

public class LoginBackEnd {

    private SceneManager sceneManager;
    private static int loginAttempts;
    private static LoginFrontEnd loginFrontEnd;
    private static User activeUser;

    //region Singleton
    private static LoginBackEnd instance;

    public static LoginBackEnd getInstance() {
        if (instance == null) {
            instance = new LoginBackEnd();
        }
        return instance;
    }

    private LoginBackEnd() {

    }
    //endregion

    public LoginBackEnd(String usernameInput, String passwordInput, LoginFrontEnd loginFrontEnd2) {
        sceneManager = SceneManager.getInstance();
        loginFrontEnd = loginFrontEnd2;
        activeUser = ReadFromDB.readFromDbToLoginIn(usernameInput, passwordInput);

        if (activeUser != null) {
            SessionManager.setActiveUser(activeUser);
            if (activeUser.getClearanceLevel().equals("Admin")) {
                sceneManager.showAccountsAdmin();
            } else {
                sceneManager.showAccountsUser();
            }
        } else {
            loginAttempts++;
            System.out.println(loginAttempts);
            if (loginAttempts >= 3) {
                loginAttempts = 0;
                sceneManager.memes();
            } else {
                loginFrontEnd.setWrongLogin(true);
            }
        }
    }
}
