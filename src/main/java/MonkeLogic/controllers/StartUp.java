package MonkeLogic.controllers;


import MonkeLogic.databasemethods.ReadFromDB;

public class StartUp {
    public StartUp() {
        SessionManager sessionManager = SessionManager.getInstance();
        CryptKeeper crypto = CryptKeeper.getInstance();
        ReadFromDB readFromDb = ReadFromDB.getInstance();
    }
}
