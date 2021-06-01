package MonkeLogic.controllers;


import MonkeLogic.dto.User;

public class SessionManager {
    private static User activeUser;
    private static SessionManager instance;

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

    public static String getActiveUserClearanceLevel() {
        return activeUser.getClearanceLevel();
    }

    public static void setActiveUser(User activeUser) {
        SessionManager.activeUser = activeUser;
    }
}
