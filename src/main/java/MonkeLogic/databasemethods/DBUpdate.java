package MonkeLogic.databasemethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUpdate {
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

}
