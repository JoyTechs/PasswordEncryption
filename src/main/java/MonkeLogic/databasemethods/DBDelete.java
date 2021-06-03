package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDelete {
    private static Connection c = null;

    //region Singleton
    private static DBDelete instance;

    public static DBDelete getInstance() {
        if (instance == null) {
            instance = new DBDelete();
        }
        return instance;
    }

    private DBDelete() {
    }
    //endregion

    public static void Delete() {
        c = DBConnection.getC();
        Statement stmt = null;

        //Todo: Edit the sql query so we can input what we want.
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE from USERS where ID=2;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("USERNAME = " + username);
                System.out.println("PASSWORD = " + password);
                System.out.println();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }
}
