package MonkeLogic.databasemethods;

import MonkeLogic.controllers.CryptKeeper;
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

    public static void initialStart() {

        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);
            statement = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL, HASSECURITYQUESTION) " +
                    "VALUES ('Admin', '" + CryptKeeper.enCrypt("FirstStart") + "', 'Admin', '" + false + "')";
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
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL, HASSECURITYQUESTION) " +
                    "VALUES ('" + user.getUsername() + "', '"
                    + CryptKeeper.enCrypt(user.getPassword()) + "', '"
                    + user.getClearanceLevel() + "', '"
                    + user.getHasSecurityQuestion() + "');";
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
                    + CryptKeeper.enCrypt(account.getPassword()) + "');";
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
            String sql = "INSERT INTO SECURITY_QUESTIONS (USERID, QUESTION, ANSWER) " +
                    "VALUES ('" + securityQuestion.getUserID() + "', '"
                    + securityQuestion.getQuestionNr() + "', '"
                    + CryptKeeper.enCrypt(securityQuestion.getAnswer()) + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Security question linked to account");
    }
}
