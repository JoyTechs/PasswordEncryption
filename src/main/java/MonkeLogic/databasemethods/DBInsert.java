package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInsert {

    public static void InsertData() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MonkeLogic.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, CLEARANCELEVEL) " +
                    "VALUES ('Admin', 'FirstStart', 'ADMIN' );";
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
}
