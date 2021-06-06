package MonkeLogic.dto;

public class UserEncryption {

    //region Singleton
    private static UserEncryption instance;

    public static UserEncryption getInstance() {
        if (instance == null) {
            instance = new UserEncryption();
        }
        return instance;
    }

    public UserEncryption() {
    }
    //endregion

    private static User newUser;
    private static int secretKey;
    private static int salt;

    public UserEncryption(User newUser, int secretKey, int salt) {
        UserEncryption.newUser = newUser;
        UserEncryption.secretKey = secretKey;
        UserEncryption.salt = salt;
    }

    public static void setInstance() {
        instance = null;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        UserEncryption.newUser = newUser;
    }

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        UserEncryption.secretKey = secretKey;
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        UserEncryption.salt = salt;
    }
}
