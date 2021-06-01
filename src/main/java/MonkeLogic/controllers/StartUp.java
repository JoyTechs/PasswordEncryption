package MonkeLogic.controllers;


import MonkeLogic.databasemethods.DBConnection;
import MonkeLogic.databasemethods.ReadFromDB;

public class StartUp {
    public StartUp() {
        DBConnection.CreateTable();
        SessionManager sessionManager = SessionManager.getInstance();
        CryptKeeper crypto = CryptKeeper.getInstance();
        ReadFromDB readFromDb = ReadFromDB.getInstance();
    }
}
