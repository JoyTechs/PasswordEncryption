package MonkeLogic.dbo;

public class Account {

    private String userId;
    private String AccountId;


    private String username;
    private String password;
    private String website;


    public Account() {

    }

    public Account(String userId, String accountId, String username, String password, String website) {
        this.userId = userId;
        this.AccountId = accountId;
        this.username = username;
        this.password = password;
        this.website = website;
    }

    public Account(String username, String password, String website) {
        this.username = username;
        this.password = password;
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getWebsite() {
        return website;
    }


}
