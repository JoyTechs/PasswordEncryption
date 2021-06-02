package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDelete {
    private static Connection c = null;

    //Todo: add To StartUp
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
        c = DBConnection.connect();
        Statement stmt = null;

        //Todo: Edit the sql query so we can input what we want.
        try {
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
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
