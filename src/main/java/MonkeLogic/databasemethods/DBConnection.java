package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static Connection getC() {
        return c;
    }

    public static Connection DBConnections() throws SQLException {
        if(c == null){
            String url = "jdbc:sqlite:MonkeLogic.db";
            Connection c =  DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }
        return c;
    }

    public static void CreateTable() {
        c = DBConnection.getC();
        Statement stmt = null;
        try {

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USERS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL ," +
                    " USERNAME             TEXT         NOT NULL , " +
                    " PASSWORD             TEXT         NOT NULL ," +
                    " CLEARANCELEVEL       TEXT         NOT NULL )";
            stmt.executeUpdate(sql);

            stmt = c.createStatement();
            String sql2 = "CREATE TABLE IF NOT EXISTS ACCOUNT " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " USERID            INTEGER     NOT NULL," +
                    " EMPLOYEE          TEXT        NOT NULL," +
                    " WEBSITE           TEXT        NOT NULL, " +
                    " USERNAME          TEXT        NOT NULL, " +
                    " PASSWORD          TEXT        NOT NULL)";
            stmt.executeUpdate(sql2);

            stmt = c.createStatement();
            String sql3 = "CREATE TABLE IF NOT EXISTS SECURITY_QUESTIONS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " USERID           INTEGER        NOT NULL," +
                    " QUESTION         TEXT           NOT NULL, " +
                    " ANSWER           TEXT           NOT NULL)";
            stmt.executeUpdate(sql3);

            stmt = c.createStatement();
            String sql4 = "CREATE TABLE IF NOT EXISTS SECURITY_KEYS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " KEY           INTEGER     NOT NULL," +
                    "FOREIGN KEY(ID) REFERENCES USERS(ID))";
            stmt.executeUpdate(sql4);

            stmt = c.createStatement();
            String sql5 = "CREATE TABLE IF NOT EXISTS LEAGUE_OF_LEGENDS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " SECRETKEY   INTEGER     NOT NULL, " +
                    " SALT        INTEGER     NOT NULL," +
                    "FOREIGN KEY(ID) REFERENCES USERS(ID))";
            stmt.executeUpdate(sql5);

            //TODO: Avgöra om USERID behövs här
            stmt = c.createStatement();
            String sql6 = "CREATE TABLE IF NOT EXISTS LIST_OF_SECURITY_QUESTIONS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
//                    " USERID            INTEGER         NOT NULL," +
                    " QUESTION          TEXT            NOT NULL)";
            stmt.executeUpdate(sql6);

            stmt.close();
            c.close();
            System.out.println("Connection to SQLite has been close");
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Table created successfully");
    }
}
