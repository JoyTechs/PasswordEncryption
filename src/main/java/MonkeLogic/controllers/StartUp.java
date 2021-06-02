package MonkeLogic.controllers;


import MonkeLogic.databasemethods.DBConnection;
import MonkeLogic.databasemethods.ReadFromDB;

public class StartUp {
    public StartUp() {
        DBConnection.CreateTable();
        System.out.println("DBConnection.CreateTable has Started");
        ChosenAccountForEdit.getInstance();
        System.out.println("ChosenAccountForEdit.getInstance has Started");
        SessionManager.getInstance();
        System.out.println("SessionManager.getInstance has Started");
        CryptKeeper.getInstance();
        System.out.println("CryptKeeper.getInstance has Started");
        ReadFromDB.getInstance();
        System.out.println("ReadFromDB.getInstance has Started");
    }
}
