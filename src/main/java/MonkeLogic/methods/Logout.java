package MonkeLogic.methods;

public class Logout {

    private static Logout instance;

    public static Logout getInstance() {
        if (instance == null) {
            instance = new Logout();
        }
        return instance;
    }

    public Logout() {
    }

    public static void logoutUser() {

    }
}
