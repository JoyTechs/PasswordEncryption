package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.services.ReadFromDb;

public class LoginBackEnd {

    private final SceneManager sceneManager;
    //private final String activeUsersID;
    //private final String activeUsersClearanceLevel;

    public LoginBackEnd(String usernameInput, String passwordInput) {
        sceneManager = SceneManager.getInstance();
        ReadFromDb.readFromDbToLoginIn(usernameInput, passwordInput);
        sceneManager.showAccounts();
    }

}
