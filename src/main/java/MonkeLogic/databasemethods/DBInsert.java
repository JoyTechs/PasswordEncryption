package MonkeLogic.databasemethods;

import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.Account;
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
    public static void initialStart() {

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

    public static void addSecurityQuestion(SecurityQuestion securityQuestion) {

        try {
            statement = c.createStatement();
            String sql = "INSERT INTO SECURITY_QUESTIONS (USERID, QUESTION, ANSWER) " +
                    "VALUES ('" + securityQuestion.getUserID() + "', '" + securityQuestion.getQuestionNr() + "', '" + securityQuestion.getAnswer() + "')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
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
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL) " +
                    "VALUES ('" + user.getUsername() + "', '"
                    + user.getPassword() + "', '"
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
                    + account.getUsername() + "', '"
                    + account.getPassword() + "');";
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
                    + securityQuestion.getAnswer() + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Security question linked to account");
    }
}
