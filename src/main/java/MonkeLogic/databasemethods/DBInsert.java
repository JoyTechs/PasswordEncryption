package MonkeLogic.databasemethods;

import java.sql.*;

public class DBInsert {

    private static Connection c = null;
    private static Statement statement = null;

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
}
