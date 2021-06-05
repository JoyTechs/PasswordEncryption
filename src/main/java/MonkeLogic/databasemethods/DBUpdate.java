package MonkeLogic.databasemethods;

import MonkeLogic.controllers.ChosenAccountForEdit;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUpdate {

    private static Connection c = null;
    private static PreparedStatement statement = null;


    //region Singleton
    private static DBUpdate instance;

    public static DBUpdate getInstance() {
        if (instance == null) {
            instance = new DBUpdate();
        }
        return instance;
    }

    private DBUpdate() {
    }

    public static void setInstance(){
        instance = null;
    }
    //endregion

    public static void updateUser(User user) {

        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);

            String query = "UPDATE USERS SET USERNAME = ? , PASSWORD = ?  WHERE ID =1";
            statement = c.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();

            c.commit();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public static void updateAccount(String website, String username, String password) {

        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);

            String query = "UPDATE ACCOUNT SET WEBSITE = ? , USERNAME = ?, PASSWORD = ? WHERE ID = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, website);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setInt(4, ChosenAccountForEdit.getChosenAccount().getUserId());

            statement.executeUpdate();


            c.commit();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public static void updatePassword(String newPassword) {
        c = DBConnection.getC();

        try {
            c.setAutoCommit(false);

            String query = "UPDATE USERS SET PASSWORD = ?  WHERE ID = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, newPassword);
            statement.setInt(2, SessionManager.getActiveUser().getUserID());
            statement.executeUpdate();


            c.commit();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }


    //TODO: Add Update for Account.

}
