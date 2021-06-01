package MonkeLogic.databasemethods;

import java.sql.*;

public class DBUpdate {

    private static Connection c = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static void Update() {

        c = DBConnection.connect();

        try {
            statement = c.createStatement();
            String sql = "UPDATE USERS set USERNAME = 'Abdibasid' where ID=1;";
            statement.executeUpdate(sql);

            statement = c.createStatement();
            String sql1 = "UPDATE USERS set PASSWORD = '1' where ID=1;";
            statement.executeUpdate(sql1);

            statement = c.createStatement();
            String sql2 = "UPDATE USERS set CLEARANCELEVEL = 'Admin' where ID=1;";
            statement.executeUpdate(sql2);

            c.commit();

            resultSet = statement.executeQuery("SELECT * FROM USERS;");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                int password = resultSet.getInt("password");
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
