package MonkeLogic.controllers;


import MonkeLogic.databasemethods.ReadFromDB;

public class StartUp {
    public StartUp() {
        CryptKeeper crypto = CryptKeeper.getInstance();
        ReadFromDB readFromDb = ReadFromDB.getInstance();
    }
}
