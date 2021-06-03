package MonkeLogic.dto;

public class Account {

    //region Variables
    private int id;
    private int userId;
    private String employee;
    private String username;
    private String password;
    private String website;
    private Boolean hasSecurityQuestion;
    //endregion

    //region Constructors
    public Account() {

    }

    public Account(int id, int userId, String website, String employee, String username, String password) {
        this.id = id;
        this.userId = userId;
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.website = website;
    }

    public Account(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }
    //endregion

    //region Getters
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmployee() {
        return employee;
    }

    public Boolean getHasSecurityQuestion() {
        return hasSecurityQuestion;
    }

    public String getPassword() {
        return password;
    }

    public String getWebsite() {
        return website;
    }
    //endregion

    //region Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setHasSecurityQuestion(Boolean hasSecurityQuestion) {
        this.hasSecurityQuestion = hasSecurityQuestion;
    }
    //endregion

}
