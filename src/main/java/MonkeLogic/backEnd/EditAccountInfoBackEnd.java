package MonkeLogic.backEnd;

import MonkeLogic.controllers.ChosenAccountForEdit;
import MonkeLogic.dto.Account;

public class EditAccountInfoBackEnd {

    private static EditAccountInfoBackEnd instance;

    public static EditAccountInfoBackEnd getInstance() {
        if (instance == null) {
            instance = new EditAccountInfoBackEnd();
        }
        return instance;
    }

    public EditAccountInfoBackEnd() {
    }

    public static void editAccount(String website, String username, String password) {

        Account account = ChosenAccountForEdit.getChosenAccount();

        account.setWebsite(website);
        account.setUsername(username);
        account.setPassword(password);
        ChosenAccountForEdit.setChosenAccount(account);
        //Todo: implement save function for this

    }

}
