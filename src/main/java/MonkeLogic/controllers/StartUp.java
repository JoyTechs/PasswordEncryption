package MonkeLogic.controllers;


import MonkeLogic.databasemethods.CreateTable;
import MonkeLogic.databasemethods.DBConnection;
import MonkeLogic.databasemethods.ReadFromDB;

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
        DBConnection.getInstance();
        ReadFromDB.getInstance();
        CreateTable.getInstance();
        System.out.println("DBConnection.CreateTable has Started");
        ChosenAccountForEdit.getInstance();
        System.out.println("ChosenAccountForEdit.getInstance has Started");
        SessionManager.getInstance();
        System.out.println("SessionManager.getInstance has Started");
        CryptKeeper.getInstance();
        System.out.println("CryptKeeper.getInstance has Started");
        System.out.println("ReadFromDB.getInstance has Started");
    }
}