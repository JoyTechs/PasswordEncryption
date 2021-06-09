package MonkeLogic.databasemethods;

import MonkeLogic.dto.Account;

import java.sql.*;

public class DBDelete {
    private static Connection c = null;
    private static PreparedStatement statement = null;

    //region Singleton
    private static DBDelete instance;

    public static DBDelete getInstance() {
        if (instance == null) {
            instance = new DBDelete();
        }
        return instance;
    }

    private DBDelete() {
    }

    public static void setInstance() {
        instance = null;
    }
    //endregion

    public static void deleteAccount(int Id) {
        c = DBConnection.getC();

        String sql = "DELETE from ACCOUNT WHERE ID = ?";

        try {
            c.setAutoCommit(false);

            statement = c.prepareStatement(sql);
            statement.setInt(1, Id);
            statement.executeUpdate();

            c.commit();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }
}
