package MonkeLogic.databasemethods;

import MonkeLogic.dto.SecurityQuestion;

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

        c = DBConnection.connect();

        try {
            statement = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL) " +
                    "VALUES ('Admin', 'FirstStart', 'ADMIN')";
            statement.executeUpdate(sql);

            statement.close();
            c.commit();
            c.close();
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
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");

    }

}
