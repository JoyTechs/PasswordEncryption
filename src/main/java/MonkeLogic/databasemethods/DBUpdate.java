package MonkeLogic.databasemethods;

import MonkeLogic.dto.User;

import java.sql.*;

public class DBUpdate {

    private static Connection c = null;
    private static PreparedStatement statement = null;
    private static DBUpdate dbUpdate;

    public static DBUpdate getInstance() {
        if (dbUpdate == null) {
            dbUpdate = new DBUpdate();
        }
        return dbUpdate;
    }

    private DBUpdate() {

    }

    public static void Update(User user) {

        c = DBConnection.connect();

        try {
            c.setAutoCommit(false);

            String query = "UPDATE USERS SET USERNAME = ? , PASSWORD = ?  WHERE ID =1";
            statement = c.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();


            c.commit();
            statement.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
