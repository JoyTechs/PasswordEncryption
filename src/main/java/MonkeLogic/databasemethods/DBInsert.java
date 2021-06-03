package MonkeLogic.databasemethods;

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
    //endregion

    public static void InitialStart() {

        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);
            statement = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL) " +
                    "VALUES ('Admin', 'FirstStart', 'ADMIN')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    //Todo: add methods for adding new Users, Security Questions and Accounts

    public static void AddSecurityQuestion(SecurityQuestion securityQuestion) {

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

    public static void CreateNewUser(User user) throws SQLException {
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
}
