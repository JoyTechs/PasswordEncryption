package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;

public class LoginBackEnd {

    private final SceneManager sceneManager;
    private final String activeUsersID;
    private final String activeUsersClearanceLevel;

    public LoginBackEnd(String username, String password, SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        activeUsersID = username;
        activeUsersClearanceLevel = password;
        //this.sceneManager.setActiveUser(activeUsersID, activeUsersClearanceLevel);
        sceneManager.login();

    }

}
