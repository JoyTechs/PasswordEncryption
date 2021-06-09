package MonkeLogic.backEnd;

import MonkeLogic.controllers.SceneManager;
import MonkeLogic.controllers.SessionManager;
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
        DBUpdate.updateAccount(account.getWebsite(), account.getUsername(), account.getPassword());

        if (SessionManager.getActiveUser().getClearanceLevel().equals("Admin")) {
            SceneManager.getInstance().showAccountsAdmin();
        } else if (SessionManager.getActiveUser().getClearanceLevel().equals("User")) {
            SceneManager.getInstance().showAccountsUser();
        }
    }
}
