package Controllers;

import Modules.Account;
import org.junit.Test;

public class AccountControllerTest {

    @Test
    public void addAccount() {
        AccountController ac = new AccountController();
        ac.add(new Account("11", Account.AccountType.GUEST, "RemyRat", "Remy123", "Remy", Account.Race.HUMAN));
        //ac.update();
    }

    @Test
    public void updateAccount() {
        AccountController ac = new AccountController();
        ac.update(new Account("11", Account.AccountType.GUEST, "RemyRaty", "Remy123", "Remy", Account.Race.HUMAN));
    }

    @Test
    public void deleteAccount() {
        AccountController ac = new AccountController();
        ac.delete(new Account("9", Account.AccountType.GUEST, "RemyRaty", "Remy123", "Remy", Account.Race.HUMAN));
    }

    @Test
    public void searchAccount() {
        AccountController ac = new AccountController();
        ac.search(new AccountController.AccountSearchQuery("", "", "", "", Account.Race.VAMPIRE.toString()));
    }

    @Test
    public void getAll() {
    }
}