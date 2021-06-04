package MonkeLogic.backEnd;

import MonkeLogic.databasemethods.DBInsert;
import MonkeLogic.dto.Account;

import java.sql.Connection;

public class CreateAccountBackEnd {

    //region Creates a Singleton
    private static CreateAccountBackEnd createAccountBackEnd;

    public static CreateAccountBackEnd getInstance() {
        if (createAccountBackEnd == null) {
            createAccountBackEnd = new CreateAccountBackEnd();
        }
        return createAccountBackEnd;
    }

    private CreateAccountBackEnd() {
    }

    public void saveAccInfo(Account account) {
        DBInsert.saveAccInfo(account);
    }
    //endregion
}
