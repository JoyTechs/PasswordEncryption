package MonkeLogic.backEnd;

import MonkeLogic.databasemethods.DBConnection;
import MonkeLogic.databasemethods.DBInsert;
import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserBackEnd {

    //TODO: add Singleton, Use DBInsert and add to StartUp

    private static CreateUserBackEnd instance;

    public static CreateUserBackEnd getInstance() {
        if (instance == null) {
            instance = new CreateUserBackEnd();
        }
        return instance;
    }

    private CreateUserBackEnd() {
    }

    public void CreateNewUser(User user) throws SQLException {
        DBInsert.CreateNewUser(user);
    }
}

