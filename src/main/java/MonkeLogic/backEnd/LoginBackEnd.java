package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;

public class LoginBackEnd {

    private final SceneManager sceneManager;
//    private final String activeUsersID;
//    private final String activeUsersClearanceLevel;

    public LoginBackEnd(String username, String password) {
        sceneManager = SceneManager.getInstance();
//        activeUsersID = username;
//        activeUsersClearanceLevel = password;
//        sceneManager.memes();
        sceneManager.createAccount();

    }

}
