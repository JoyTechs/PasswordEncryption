package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection c = null;

    private static DBConnection instance;

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DBConnection();
            c = DBConnections();
        }
        return instance;
    }

    public static void setInstance() {
        instance = null;
    }

    public static Connection getC() {
        return c;
    }

    public static Connection DBConnections() throws SQLException, ClassNotFoundException {
        if (c == null) {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            System.out.println("Connection to SQLite has been established.");
        }
        return c;
    }

}
