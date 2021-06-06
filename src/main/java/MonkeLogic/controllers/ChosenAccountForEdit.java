package MonkeLogic.controllers;

import MonkeLogic.dto.Account;

public class ChosenAccountForEdit {


    private static Account chosenAccount;
    //region Singleton
    private static ChosenAccountForEdit instance;

    public static ChosenAccountForEdit getInstance() {
        if (instance == null) {
            instance = new ChosenAccountForEdit();
        }
        return instance;
    }

    private ChosenAccountForEdit() {
    }

    public static void setInstance() {
        instance = null;
    }
    //endregion

    public static void setChosenAccount(Account chosenAccount) {
        ChosenAccountForEdit.chosenAccount = chosenAccount;
    }

    public static Account getChosenAccount() {
        return chosenAccount;
    }

}
