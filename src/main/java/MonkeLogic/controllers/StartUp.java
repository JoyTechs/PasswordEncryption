package MonkeLogic.controllers;


import MonkeLogic.services.ReadFromDb;

public class StartUp {
    public StartUp() {
        CryptKeeper crypto = CryptKeeper.getInstance();
        ReadFromDb readFromDb = ReadFromDb.getInstance();

    }
}
