package MonkeLogic.backEnd;

import MonkeLogic.controllers.ChosenAccountForEdit;
import MonkeLogic.controllers.CryptKeeper;
import MonkeLogic.databasemethods.DBUpdate;
import MonkeLogic.dto.Account;

public class EditAccountInfoBackEnd {

    //region Singleton
    private static EditAccountInfoBackEnd instance;

    public static EditAccountInfoBackEnd getInstance() {
        if (instance == null) {
            instance = new EditAccountInfoBackEnd();
        }
        return instance;
    }

    public EditAccountInfoBackEnd() {
    }
    //endregion

    public static void editAccount(Account account) {
        DBUpdate.updateAccount(account.getWebsite(),account.getUsername(),account.getPassword());
        account = ChosenAccountForEdit.getChosenAccount();

        account.setWebsite(account.getWebsite());
        account.setUsername(account.getUsername());
        account.setPassword(account.getPassword());
        ChosenAccountForEdit.setChosenAccount(account);

        //Todo: implement save function for this

    }

}
