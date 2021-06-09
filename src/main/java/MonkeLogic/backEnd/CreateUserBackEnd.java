package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.databasemethods.DBInsert;
import MonkeLogic.databasemethods.DBSelect;
import MonkeLogic.dto.User;

import java.sql.SQLException;

public class CreateUserBackEnd {

    private static CreateUserBackEnd instance;

    public static CreateUserBackEnd getInstance() {
        if (instance == null) {
            instance = new CreateUserBackEnd();
        }
        return instance;
    }

    private CreateUserBackEnd() {
    }

    public static void createNewUser(User user) throws SQLException {

        if (DBSelect.validationOfUsername(user.getUsername())) {
            System.out.println("Please try again! ");
        } else {
            DBInsert.createNewUser(user);
            if (SessionManager.getActiveUserClearanceLevel().equals("Admin")) {
                SceneManager.getInstance().showAccountsAdmin();
            } else if (SessionManager.getActiveUserClearanceLevel().equals("User")) {
                SceneManager.getInstance().showAccountsUser();
            }
        }
    }
}

