package MonkeLogic.dbo;

public class User {

    private final int userID;
    private final String username;
    private final String password;
    private final String clearanceLevel;

    public User(int userID, String username, String password, String clearanceLevel) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
    }
}
