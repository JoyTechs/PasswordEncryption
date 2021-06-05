package MonkeLogic.backEnd;

import MonkeLogic.databasemethods.DBInsert;
import MonkeLogic.dto.Account;

public class CreateAccountBackEnd {

    //region Creates a Singleton
    private static CreateAccountBackEnd instance;

    public static CreateAccountBackEnd getInstance() {
        if (instance == null) {
            instance = new CreateAccountBackEnd();
        }
        return instance;
    }

    private CreateAccountBackEnd() {
    }

    public void saveAccInfo(Account account) {
        DBInsert.saveAccInfo(account);
    }
    //endregion
}
