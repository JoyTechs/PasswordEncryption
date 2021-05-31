package MonkeLogic.services;

import MonkeLogic.DbConnection;

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

    public static void readFromDbToLoginIn(String username, String password) {
        c = DbConnection.connect();
        try {
            String query = "SELECT * FROM USERS WHERE USERNAME = ? and PASSWORD = ? ";
            statement = c.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
            }
            if (count == 1) {
                System.out.println("Username and password is correct");
            } else {
                System.out.println("Username and password is incorrect");
            }
            statement.close();
            resultSet.close();
            c.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
