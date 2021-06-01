package MonkeLogic.dto;

public class User {

    private int userID;
    private String username;
    private String password;
    private String clearanceLevel;

    public User(int userID, String username, String password, String clearanceLevel) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
    }

    //region Setters
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClearanceLevel(String clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
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