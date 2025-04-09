package STORMSPRID.user;

import STORMSPRID.account.Account;

import java.util.List;
@
public class User {
    private final int id;
    private final String login;
    private final List<Account> accountList;

    public User(int id, String login, List<Account> accountList) {
        this.id = id;
        this.login = login;
        this.accountList = accountList;
    }
}
