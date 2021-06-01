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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Account(String username, String password, String website) {
        this.username = username;
        this.password = password;
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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


}
