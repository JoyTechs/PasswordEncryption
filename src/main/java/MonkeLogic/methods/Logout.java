package MonkeLogic.methods;

import MonkeLogic.backEnd.AnswerSecurityQuestionBackEnd;
import MonkeLogic.controllers.*;
import MonkeLogic.databasemethods.*;
import MonkeLogic.dto.UserEncryption;

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

    public static void setInstance() {
        instance = null;
    }
    //endregion

    public static void logoutUser() throws SQLException, ClassNotFoundException {
        CryptKeeper.setInstance();
        UserEncryption.setInstance();
        DBConnection.setInstance();
        CreateTable.setInstance();
        DBSelect.setInstance();
        DBInsert.setInstance();
        DBUpdate.setInstance();
        DBDelete.setInstance();
        ChosenAccountForEdit.setInstance();
        SessionManager.setInstance();
        UserEncryption.setInstance();
        AnswerSecurityQuestionBackEnd.setInstance();
        StartUp.getInstance();
        SceneManager.getInstance().login();
    }
}