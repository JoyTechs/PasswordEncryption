package MonkeLogic.databasemethods;

import java.sql.*;

public class DBSelect {

    private static Connection c = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    public static void Select() {

        c = DBConnection.connect();

        try {
            statement = c.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USERS;");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String clearancelevel = resultSet.getString("clearancelevel");

                System.out.println("ID = " + id);
                System.out.println("USERNAME = " + username);
                System.out.println("PASSWORD = " + password);
                System.out.println("CLEARANCELEVEL = " + clearancelevel);
                System.out.println();
            }
            resultSet.close();
            statement.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
