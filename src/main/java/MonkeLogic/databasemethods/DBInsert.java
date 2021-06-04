package MonkeLogic.databasemethods;

import MonkeLogic.controllers.CryptKeeper;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.Account;
import MonkeLogic.dto.EncryptedString;
import MonkeLogic.dto.SecurityQuestion;
import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInsert {

    private static Connection c = null;
    private static Statement statement = null;

    //region Singleton
    private static DBInsert instance;

    public static DBInsert getInstance() {
        if (instance == null) {
            instance = new DBInsert();
        }
        return instance;
    }

    private DBInsert() {
    }
    public static void setInstance(){
        instance = null;
    }

    //endregion

    //Todo: Check if the initialstart is used or not.
    //Todo: Chech so it only inserts one time and not everytime the program is used
    public static void InitialStart() {

        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);
            statement = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL, HASSECURITYQUESTION) " +
                    "VALUES ('Admin', 'FirstStart', 'Admin', '" + true + "')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    //Todo: add methods for adding new Users, Security Questions and Accounts

    public static void AddSecurityQuestion(SecurityQuestion securityQuestion) {

        try {
            statement = c.createStatement();
            String sql = "INSERT INTO SECURITY_QUESTIONS (USERID, QUESTION, ANSWER) " +
                    "VALUES ('" + CryptKeeper.initEncrypt(String.valueOf(securityQuestion.getUserID())) + "'," +
                    " '" + CryptKeeper.initEncrypt(String.valueOf(securityQuestion.getQuestionNr())) + "', " +
                    "'" + CryptKeeper.initEncrypt(securityQuestion.getAnswer()) + "')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public static void CreateNewUser(User user) throws SQLException {
        c = DBConnection.getC();
        Statement stmt = null;
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL) " +
                    "VALUES ('" + CryptKeeper.initEncrypt(user.getUsername()) + "', '"
                    + CryptKeeper.initEncrypt(user.getPassword()) + "', '"
                    + user.getClearanceLevel() + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public static void saveAccInfo(Account account) {
        c = DBConnection.getC();
        Statement stmt = null;
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO ACCOUNT (USERID, EMPLOYEE, WEBSITE, USERNAME, PASSWORD) " +
                    "VALUES ('" + SessionManager.getActiveUser().getUserID() + "', '"
                    + SessionManager.getActiveUser().getUsername() + "', '"
                    + account.getWebsite() + "', '"
                    + CryptKeeper.initEncrypt(account.getUsername()) + "', '"
                    + CryptKeeper.initEncrypt(account.getPassword()) + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public static void saveSecurityQuestion(SecurityQuestion securityQuestion) {
        c = DBConnection.getC();
        Statement stmt = null;
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            //TODO: Fixa till detta
            String sql = "INSERT INTO SECURITY_QUESTIONS (USERID, QUESTION, ANSWER) " +
                    "VALUES ('" + securityQuestion.getUserID() + "', '"
                    + securityQuestion.getQuestionNr() + "', '"
                    + CryptKeeper.initEncrypt(securityQuestion.getAnswer()) + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Security question linked to account");
    }

    public static void initEncrypt(EncryptedString encryptedString){
        c = DBConnection.getC();
        Statement stmt = null;
        try {
        statement = c.createStatement();
        String sql = "INSERT INTO SALTS (USERID, SECRETKEY, SALT) " +
                "VALUES ('" + SessionManager.getActiveUser().getUserID() + "'," +
                " '" + encryptedString.getSecretKey() + "', " +
                "'" + encryptedString.getSalt() + "')";
        statement.executeUpdate(sql);

        statement.close();
        c.commit();
    } catch (SQLException e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
        System.out.println("Encryption values assigned to user");
    }
}
