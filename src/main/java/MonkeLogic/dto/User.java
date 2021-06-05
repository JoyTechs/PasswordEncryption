package MonkeLogic.dto;

public class User {

    //region Variables
    private int userID;
    private String username;
    private String password;
    private String clearanceLevel;
    private Boolean hasSecurityQuestion;
    //endregion

    //region Constructors

    public User() {
    }

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

    public User(int userID, String username, String password, String clearanceLevel, Boolean hasSecurityQuestion) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
        this.hasSecurityQuestion = hasSecurityQuestion;
    }

    public User(String username, String password, String clearanceLevel, Boolean hasSecurityQuestion) {
        this.username = username;
        this.password = password;
        this.clearanceLevel = clearanceLevel;
        this.hasSecurityQuestion = hasSecurityQuestion;
    }

    public User(String username) {
        this.username = username;
    }
    //endregion

    //region Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHasSecurityQuestion(Boolean hasSecurityQuestion) {
        this.hasSecurityQuestion = hasSecurityQuestion;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public Boolean getHasSecurityQuestion() {
        return hasSecurityQuestion;
    }
    //endregion Getters

}