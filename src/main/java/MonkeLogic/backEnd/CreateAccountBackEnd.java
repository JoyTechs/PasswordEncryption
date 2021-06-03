package MonkeLogic.backEnd;

import MonkeLogic.databasemethods.DBConnection;
import MonkeLogic.dto.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountBackEnd {

    private static Connection c = null;

    //region Creates a Singleton
    private static CreateAccountBackEnd createAccountBackEnd;

    public static CreateAccountBackEnd getInstance() {
        if (createAccountBackEnd == null) {
            createAccountBackEnd = new CreateAccountBackEnd();
        }
        return createAccountBackEnd;
    }

    private CreateAccountBackEnd() {
    }
    //endregion

    public void saveAccInfo(Account account) {
        c = DBConnection.connect();
        Statement stmt = null;
        try {

            stmt = c.createStatement();
            String sql = "INSERT INTO ACCOUNT (WEBSITE, USERNAME, PASSWORD) " +
                    "VALUES ('" + account.getWebsite() + "', '"
                    + account.getUsername() + "', '"
                    + account.getPassword() + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

}
