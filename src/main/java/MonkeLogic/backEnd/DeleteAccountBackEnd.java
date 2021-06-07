package MonkeLogic.backEnd;

import MonkeLogic.controllers.ChosenAccountForEdit;
import MonkeLogic.databasemethods.DBDelete;


public class DeleteAccountBackEnd {

    private static DeleteAccountBackEnd instance;

    public static DeleteAccountBackEnd getInstance() {
        if (instance == null) {
            instance = new DeleteAccountBackEnd();
        }
        return instance;
    }

    private DeleteAccountBackEnd() {
    }

    public void deleteAccount(){
       DBDelete.deleteAccount(ChosenAccountForEdit.getChosenAccount().getId());
    }
}
