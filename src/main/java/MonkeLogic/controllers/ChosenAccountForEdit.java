package MonkeLogic.controllers;

import MonkeLogic.dto.Account;

public class ChosenAccountForEdit {


    private static Account chosenAccount;
    //region Singleton
    //TODO: Add to StartUp
    private static ChosenAccountForEdit instance;

    public static ChosenAccountForEdit getInstance() {
        if (instance == null) {
            instance = new ChosenAccountForEdit();
        }
        return instance;
    }

    private ChosenAccountForEdit() {
    }
    //endregion

    public static void setChosenAccount(Account chosenAccount) {
        ChosenAccountForEdit.chosenAccount = chosenAccount;
    }

    public static Account getChosenAccount() {
        return chosenAccount;
    }

}
