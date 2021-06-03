package MonkeLogic.dto;

public class User {

    //region Variables
    private int userID;
    private String username;
    private String password;
    private String clearanceLevel;
    //endregion

    //region Constructors
    public User(int userID, String username, String password, String clearanceLevel) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String clearanceLevel) {
        this.username = username;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
    }
    //endregion

    //TODO: Check Which Setters & Getters are Necessary.
    //region Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion

    //region Getters
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getClearanceLevel() {
        return clearanceLevel;
    }
    //endregion Getters

}