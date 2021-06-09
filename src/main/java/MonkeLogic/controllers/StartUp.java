package MonkeLogic.controllers;


import MonkeLogic.backEnd.AnswerSecurityQuestionBackEnd;
import MonkeLogic.databasemethods.*;
import MonkeLogic.dto.UserEncryption;
import MonkeLogic.methods.Logout;

import java.sql.SQLException;

public class StartUp {

    private static StartUp instance;

    public static StartUp getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new StartUp();
        }
        return instance;
    }

    public StartUp() throws SQLException, ClassNotFoundException {
        CryptKeeper.getInstance();
        UserEncryption.getInstance();
        DBConnection.getInstance();
        CreateTable.getInstance();
        DBSelect.getInstance();
        DBInsert.getInstance();
        DBUpdate.getInstance();
        DBDelete.getInstance();

        if (!DBSelect.lookForDefaultAdmin()) {
            DBInsert.initialStart();
        }

        SceneManager.getInstance();
        Logout.getInstance();
        ChosenAccountForEdit.getInstance();
        SessionManager.getInstance();
        UserEncryption.getInstance();
        AnswerSecurityQuestionBackEnd.getInstance();
    }
}