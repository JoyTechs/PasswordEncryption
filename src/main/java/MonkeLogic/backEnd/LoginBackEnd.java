package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.dto.User;
import MonkeLogic.frontEnd.LoginFrontEnd;
import MonkeLogic.services.ReadFromDb;

public class LoginBackEnd {

    private final SceneManager sceneManager;
    private static int loginAttempts;
    private static LoginFrontEnd loginFrontEnd;
    private static User activeUser;

    public LoginBackEnd(String usernameInput, String passwordInput, LoginFrontEnd loginFrontEnd2) {
        sceneManager = SceneManager.getInstance();
        loginFrontEnd = loginFrontEnd2;
        activeUser = ReadFromDb.readFromDbToLoginIn(usernameInput, passwordInput);

        if (activeUser != null) {
            SceneManager.setActiveUser(activeUser);
            sceneManager.showAccountsUser();
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
