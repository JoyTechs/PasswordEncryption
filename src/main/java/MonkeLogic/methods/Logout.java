package MonkeLogic.methods;

public class Logout {

    //TODO: Add To StartUp
    //region Singleton
    private static Logout instance;

    public static Logout getInstance() {
        if (instance == null) {
            instance = new Logout();
        }
        return instance;
    }

    private Logout() {
    }
    //endregion

    //TODO: Finish Class
    public static void logoutUser() {

    }
}
