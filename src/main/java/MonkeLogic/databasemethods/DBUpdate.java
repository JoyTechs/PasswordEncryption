package MonkeLogic.databasemethods;

import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUpdate {

    private static Connection c = null;
    private static PreparedStatement statement = null;

    //Todo: add To StartUp
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
    //endregion

    public static void Update(User user) {

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

    //TODO: Add Update for Account.
}
