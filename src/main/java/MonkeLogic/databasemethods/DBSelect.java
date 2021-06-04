package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelect {

    private static Connection c = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    //region Singleton
    private static DBSelect instance;

    public static DBSelect getInstance() {
        if (instance == null) {
            instance = new DBSelect();
        }
        return instance;
    }

    private DBSelect() {
    }

    public static void setInstance(){
        instance = null;
    }
    //endregion

    public static void Select() {

        c = DBConnection.getC();

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
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }
    //TODO: Add more Select Options.
}
