package STORMSPRID.user;

import STORMSPRID.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private final long id;
    private final String login;
    private final List<Account> accountList;


}
