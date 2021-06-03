package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    private static Connection c = null;

    public static Connection connect() {

        //TODO: kolla om databasen finns redan annars så ska den skapas.
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            System.out.println("Connected with database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }

    public static void CreateTable() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USERS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL ," +
                    " USERNAME             TEXT         NOT NULL , " +
                    " PASSWORD             TEXT         NOT NULL ," +
                    " CLEARANCELEVEL       TEXT         NOT NULL ," +
                    " HASSECURITYQUESTION  BOOLEAN      NOT NULL )";
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
                    " QUESTION         INTEGER        NOT NULL, " +
                    " ANSWER           TEXT           NOT NULL)";
            stmt.executeUpdate(sql3);

            stmt = c.createStatement();
            String sql4 = "CREATE TABLE IF NOT EXISTS SECURITY_KEYS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " USERID        INTEGER     NOT NULL, " +
                    " KEY           INTEGER     NOT NULL)";
            stmt.executeUpdate(sql4);

            stmt = c.createStatement();
            String sql5 = "CREATE TABLE IF NOT EXISTS SALTS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " USERID      INTEGER     NOT NULL, " +
                    " SECRETKEY   INTEGER     NOT NULL, " +
                    " SALT        INTEGER     NOT NULL)";
            stmt.executeUpdate(sql5);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
