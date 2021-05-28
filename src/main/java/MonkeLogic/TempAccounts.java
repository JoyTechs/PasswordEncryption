package MonkeLogic;

import MonkeLogic.dbo.Account;

import java.util.List;

public class TempAccounts {

    private static List<Account> tempAccounts;

    public TempAccounts() {
        addAccountToList(1, 1, "Abdi", "Jag1234", "Google");
        addAccountToList(2, 2, "Andrej", "Orkar12", "Twitter");
        addAccountToList(3, 3, "Jakob", "Inte123", "Google");
        addAccountToList(4, 4, "Isa", "Mer1234", "Twitter");
        addAccountToList(5, 5, "Elias", "Idag123", "Baguette");
        addAccountToList(6, 6, "Penguin", "Vi12345", "Glömde");
        addAccountToList(7, 7, "Java", "Tar1234", "Hur");
        addAccountToList(8, 8, "Alexander", "Helg.12", "Formatteringen");
        addAccountToList(9, 9, "Marcus", "Vi12345", "Fungerade");
        addAccountToList(10, 10, "August", "Ses.123", "Här");
    }

    public List<Account> getTempAccounts() {
        return tempAccounts;
    }

    private void addAccountToList(int userId, int accountId, String username, String password, String website) {
        Account account = new Account(String.valueOf(userId), String.valueOf(accountId), username, password, website);
    }

}
