package MonkeLogic.methods;

import MonkeLogic.databasemethods.*;

import java.sql.SQLException;

public class Logout {

    //region Singleton
    private static Logout instance;

    public static Logout getInstance() {
        if (instance == null) {
            instance = new Logout();
        }
        return instance;
    }

    private Logout() {
    }
    //endregion

    //TODO: Finish Class
    public static void logoutUser() throws SQLException, ClassNotFoundException {
        //TODO: Set everything in StartUp to Null, then Call StartUp again.
        DBConnection.getInstance();
        CreateTable.getInstance();
        ReadFromDB.getInstance();
        DBInsert.getInstance();
        DBUpdate.getInstance();
        DBSelect.getInstance();
        DBDelete.getInstance();
        DBInsert.InitialStart();
    }
}