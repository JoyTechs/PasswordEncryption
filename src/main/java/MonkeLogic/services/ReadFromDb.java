package MonkeLogic.services;

import MonkeLogic.databasemethods.DbConnection;
import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadFromDb {
    private static ReadFromDb readFromDb;
    private static Connection c = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;


    private ReadFromDb() {

    }

    public static ReadFromDb getInstance() {
        if (readFromDb == null) {
            readFromDb = new ReadFromDb();
        }
        return readFromDb;
    }

    public static User readFromDbToLoginIn(String username, String password) {
        User user = null;
        c = DbConnection.connect();
        try {
            String query = "SELECT * FROM USERS WHERE USERNAME = ? and PASSWORD = ? LIMIT 0,1";
            statement = c.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
                System.out.println(count);

                if (count == 1) {
                    System.out.println("Username and password is correct");
                    user = new User(Integer.parseInt(
                            resultSet.getString("ID")),
                            resultSet.getString("USERNAME"),
                            resultSet.getString("PASSWORD"),
                            resultSet.getString("CLEARANCELEVEL"));
                    return user;
                } else {
                    System.out.println("Username and password is incorrect");
                }
            }
            statement.close();
            resultSet.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Boolean firstStart() {
        User user = null;
        c = DbConnection.connect();

        try {

            String query = "SELECT * FROM USERS WHERE ID = 1 and USERNAME = ? and PASSWORD = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, "Admin");
            statement.setString(2, "FirstStart");

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
            }
            if (count == 1) {
                System.out.println("Username and password is correct");
                return true;

            } else {

                System.out.println("Not First Start");
            }
            statement.close();
            resultSet.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }


}
