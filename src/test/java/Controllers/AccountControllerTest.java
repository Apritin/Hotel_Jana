package Controllers;

import Modules.Account;
import org.junit.Test;

public class AccountControllerTest {

    @Test
    public void addAccount() {
        AccountController ac = new AccountController();
        ac.addAccount(new Account("9", Account.AccountType.GUEST, "RemyRat", "Remy123", "Remy", Account.Race.HUMAN));
        ac.update();
    }

    @Test
    public void updateAccount() {
        AccountController ac = new AccountController();
        ac.updateAccount(new Account("9", Account.AccountType.GUEST, "RemyRaty", "Remy123", "Remy", Account.Race.HUMAN));
        ac.update();
    }

    @Test
    public void deleteAccount() {
        AccountController ac = new AccountController();
        ac.deleteAccount(new Account("9", Account.AccountType.GUEST, "RemyRaty", "Remy123", "Remy", Account.Race.HUMAN));
        ac.update();
    }

    @Test
    public void searchAccount() {
        AccountController ac = new AccountController();
        //ac.searchAccount(new Account("", Account.AccountType.GUEST, "", "", "Remy", Account.Race.HUMAN));
    }

    @Test
    public void getAll() {
    }
}