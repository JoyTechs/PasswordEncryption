package MonkeLogic.backEnd;

import MonkeLogic.databasemethods.DBInsert;
import MonkeLogic.databasemethods.ReadFromDB;
import MonkeLogic.dto.User;

import java.sql.SQLException;

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
        User newUser = ReadFromDB.readFromDB(user.getUsername());
        if (user.getUsername().equals(newUser.getUsername())){
            System.out.println("Please try again! ");
        } else {
            DBInsert.CreateNewUser(user);
        }
    }
}

