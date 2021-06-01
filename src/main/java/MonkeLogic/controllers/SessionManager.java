package MonkeLogic.controllers;

import MonkeLogic.dbo.User;

public class SessionManager {
    private static User activeUser;
    private static SessionManager instance;

    //TODO: Add to StartUp
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();

        }
        return instance;
    }

    private SessionManager() {
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User activeUser) {
        SessionManager.activeUser = activeUser;
    }
}
