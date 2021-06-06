package MonkeLogic.controllers;


import MonkeLogic.databasemethods.*;
import MonkeLogic.dto.UserEncryption;
import MonkeLogic.methods.Logout;

import java.sql.SQLException;

public class StartUp {

    //Todo: Fix StartUp
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

        //DBInsert.initialStart();
        System.out.println("ReadFromDB.getInstance has Started");
        SceneManager.getInstance();
        //TODO: ta bort // från denna raden CreateUserBackEnd.getInstance();
        Logout.getInstance();
        System.out.println("DBConnection.CreateTable has Started");
        ChosenAccountForEdit.getInstance();
        System.out.println("ChosenAccountForEdit.getInstance has Started");
        SessionManager.getInstance();
        System.out.println("SessionManager.getInstance has Started");
        System.out.println("CryptKeeper.getInstance has Started");
        UserEncryption.getInstance();

    }
}