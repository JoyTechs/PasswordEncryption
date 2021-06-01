package MonkeLogic.backEnd;

import MonkeLogic.dto.Account;

public class EditAccountInfoBackEnd {

    public EditAccountInfoBackEnd() {
    }

    public Account editAcount(String website, String username, String password, Account account) {
        account.setWebsite(website);
        account.setUsername(username);
        account.setPassword(password);
        return account;
        //Todo: implement save function for this

    }

}
