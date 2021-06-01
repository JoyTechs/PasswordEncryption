package MonkeLogic.dto;

public class Account {

    private int userId;
    private int AccountId;
    private String user;
    private String username;
    private String password;
    private String website;


    public Account() {

    }

    public Account(int userId, int accountId, String user, String username, String password, String website) {
        this.userId = userId;
        this.AccountId = accountId;
        this.user = user;
        this.username = username;
        this.password = password;
        this.website = website;
    }

    public Account( String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }


    //region Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getWebsite() {
        return website;
    }

    public int getUserId() {
        return userId;
    }

    public int getAccountId() {
        return AccountId;
    }

    public String getUser() {
        return user;
    }
    //endregion

    //region Setters
    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser(String user) {
        this.user = user;
    }
    //endregion


}
