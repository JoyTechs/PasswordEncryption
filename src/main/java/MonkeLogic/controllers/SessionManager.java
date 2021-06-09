package MonkeLogic.controllers;


import MonkeLogic.dto.User;

public class SessionManager {
    private static User activeUser;
    private static Boolean isThisElias;
    //region Singleton
    private static SessionManager instance;

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();

        }
        return instance;
    }

    public static void setInstance() {
        instance = null;
    }

    private SessionManager() {
    }
    //endregion

    public static User getActiveUser() {
        return activeUser;
    }

    public static String getActiveUserClearanceLevel() {
        return activeUser.getClearanceLevel();
    }

    public static void setActiveUser(User activeUser) {
        SessionManager.activeUser = activeUser;
    }

    public static Boolean getIsThisElias() {
        System.out.println("Is this Elias " + isThisElias);
        return isThisElias;
    }

    public static void setIsThisElias(Boolean isThisElias) {
        System.out.println("Is this Elias " + isThisElias);
        SessionManager.isThisElias = isThisElias;
    }
}
