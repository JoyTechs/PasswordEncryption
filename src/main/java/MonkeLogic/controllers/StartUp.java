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
        ReadFromDB.getInstance();
        DBInsert.getInstance();
        DBUpdate.getInstance();
        DBSelect.getInstance();
        DBDelete.getInstance();
        /*
        User user = new User();
        user = ReadFromDB.lookForAdmin(user);
        if (user == null){
            System.out.println("Not First Start");
        } else {
            DBInsert.initialStart();
        }

        */

        DBInsert.initialStart();
        SceneManager.getInstance();
        Logout.getInstance();
        ChosenAccountForEdit.getInstance();
        SessionManager.getInstance();
        UserEncryption.getInstance();
        AnswerSecurityQuestionBackEnd.getInstance();

    }
}