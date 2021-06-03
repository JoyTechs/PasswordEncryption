package MonkeLogic.controllers;


import MonkeLogic.databasemethods.*;
import MonkeLogic.methods.Logout;

public class StartUp {

    //Todo: Fix StartUp
    private static StartUp instance;

    public static StartUp getInstance() {
        if (instance == null) {
            instance = new StartUp();
        }
        return instance;
    }

    public StartUp() {
        DBConnection.connect();
        DBConnection.CreateTable();
        DBInsert.getInstance();
        DBUpdate.getInstance();
        DBSelect.getInstance();
        DBDelete.getInstance();
        ReadFromDB.getInstance();
        System.out.println("ReadFromDB.getInstance has Started");
        SceneManager.getInstance();
        //TODO: ta bort // från denna raden CreateUserBackEnd.getInstance();
        Logout.getInstance();
        System.out.println("DBConnection.CreateTable has Started");
        ChosenAccountForEdit.getInstance();
        System.out.println("ChosenAccountForEdit.getInstance has Started");
        SessionManager.getInstance();
        System.out.println("SessionManager.getInstance has Started");
        CryptKeeper.getInstance();
        System.out.println("CryptKeeper.getInstance has Started");

    }
}