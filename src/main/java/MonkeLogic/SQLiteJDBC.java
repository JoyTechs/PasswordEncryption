package MonkeLogic;

import java.sql.*;

public class SQLiteJDBC {
    public static void main(String[] args) {
        CreateDB();
        CreateTable();
        InsertData();
    }

    public static void CreateDB() {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            System.out.println("Opened database successfully");
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " FIRSTNAME            TEXT         NOT NULL, " +
                    " LASTNAME             TEXT         NOT NULL, " +
                    " USERNAME             TEXT         NOT NULL , " +
                    " PASSWORD             TEXT         NOT NULL)";
            stmt.executeUpdate(sql);

            stmt = c.createStatement();
            String sql2 = "CREATE TABLE IF NOT EXISTS ACCOUNT " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " WEBSITE           TEXT    NOT NULL, " +
                    " USERNAME          TEXT    NOT NULL, " +
                    " PASSWORD          TEXT    NOT NULL," +
                    "FOREIGN KEY(ID) REFERENCES USERS(ID))";
            stmt.executeUpdate(sql2);

            stmt = c.createStatement();
            String sql3 = "CREATE TABLE IF NOT EXISTS SECURITY_QUESTIONS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " QUESTION         TEXT     NOT NULL, " +
                    " ANSWER           TEXT     NOT NULL," +
                    "FOREIGN KEY(ID) REFERENCES USERS(ID))";
            stmt.executeUpdate(sql3);

            stmt = c.createStatement();
            String sql4 = "CREATE TABLE IF NOT EXISTS SECURITY_KEYS " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " KEY           INTEGER     NOT NULL," +
                    "FOREIGN KEY(ID) REFERENCES USERS(ID))";
            stmt.executeUpdate(sql4);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void InsertData() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) " +
                    "VALUES ('Abdi', 'Hussein', 'Abdi10', '123456' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public static void Select() {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("name");
                String lastname = rs.getString("lastname");
                String username = rs.getString("address");
                String password = rs.getString("salary");

                System.out.println("ID = " + id);
                System.out.println("FIRSTNAME = " + firstname);
                System.out.println("LASTNAME = " + lastname);
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

    public static void Update() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE USERS set FIRSTNAME = 'Abdibasid' where ID=1;";
            stmt.executeUpdate(sql);

            stmt = c.createStatement();
            String sql1 = "UPDATE USERS set LASTNAME = '1' where ID=1;";
            stmt.executeUpdate(sql1);

            stmt = c.createStatement();
            String sql2 = "UPDATE USERS set USERNAME = '1' where ID=1;";
            stmt.executeUpdate(sql2);

            stmt = c.createStatement();
            String sql3 = "UPDATE USERS set PASSWORD = '1' where ID=1;";
            stmt.executeUpdate(sql3);

            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
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

    public static void Delete() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from USERS where ID=2;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("ID = " + id);
                System.out.println("FIRSTNAME = " + firstname);
                System.out.println("LASTNAME = " + lastname);
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
