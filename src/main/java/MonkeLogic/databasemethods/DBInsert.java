package MonkeLogic.databasemethods;

import MonkeLogic.controllers.CryptKeeper;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.Account;
import MonkeLogic.dto.SecurityQuestion;
import MonkeLogic.dto.User;
import MonkeLogic.dto.UserEncryption;

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
    public static void initialStart() {

        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);
            statement = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL, HASSECURITYQUESTION) " +
                    "VALUES ('Admin', '" + CryptKeeper.initEncrypt("FirstStart") + "', 'Admin', '" + true + "')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
            UserEncryption.getInstance().setNewUser(new User("Admin", "FirstStart", "Admin", true));
            UserEncryption.getInstance().getNewUser().setUserID(1);
            DBInitEncrypt();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    //Todo: add methods for adding new Users, Security Questions and Accounts

    public static void addSecurityQuestion(SecurityQuestion securityQuestion) {

        try {
            //TODO: FIX THIS HSIT
            statement = c.createStatement();
            String sql = "INSERT INTO SECURITY_QUESTIONS (USERID, QUESTION, ANSWER) " +
                    "VALUES ('" + securityQuestion.getUserID() + "'," +
                    " '" + securityQuestion.getQuestionNr() + "', " +
                    "'" + CryptKeeper.enCrypt(securityQuestion.getAnswer(), securityQuestion.getUserID()) + "')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
            UserEncryption.getInstance().setNewUser(null);
            UserEncryption.getInstance().getNewUser().setUserID(securityQuestion.getUserID());

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public static void createNewUser(User user) throws SQLException {
        c = DBConnection.getC();
        Statement stmt = null;

        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL, HASSECURITYQUESTION) " +
                    "VALUES ('" + user.getUsername() + "', '"
                    + CryptKeeper.initEncrypt(user.getPassword()) + "', '"
                    + user.getClearanceLevel() + "', '"
                    + user.getHasSecurityQuestion() + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            UserEncryption.getInstance().setNewUser(user);
            UserEncryption.getInstance().getNewUser().setUserID(ReadFromDB.getLastAddedUserID());
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
                    + account.getUsername() + "', '"
                    + CryptKeeper.enCrypt(account.getPassword(), SessionManager.getActiveUser().getUserID()) + "');";
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
                    + CryptKeeper.enCrypt(securityQuestion.getAnswer(), securityQuestion.getUserID()) + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            UserEncryption.getInstance().setNewUser(SessionManager.getActiveUser());
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Security question linked to account");
    }

    public static void DBInitEncrypt() {
        c = DBConnection.getC();
        Statement stmt = null;
        try {
            statement = c.createStatement();
            String sql = "INSERT INTO SALTS (USERID, SECRETKEY, SALT) " +
                    "VALUES ('" + UserEncryption.getInstance().getNewUser().getUserID() + "'," +
                    " '" + UserEncryption.getInstance().getSecretKey() + "', " +
                    "'" + UserEncryption.getInstance().getSalt() + "')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Encryption values assigned to user");
    }
}
