package STORMSPRID.account;

import STORMSPRID.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountService {
    private final Map<Long,Account> accountMap;
    private int idCounter;

    public AccountService() {
        this.accountMap = new HashMap<>();
        this.idCounter = 0;
    }

    public Account createAccount(User user){
        idCounter++;
        Account newAccount = new Account(idCounter,user.getId(),0);
        accountMap.put(newAccount.getId(),newAccount);
        return newAccount;
    }
    public Optional<Account> findAccountById(long id){
        return Optional.ofNullable(accountMap.get(id));

    }


    public List<Account> getAllUserAccounts(long userId){
        return accountMap
                .values()
                .stream().
                filter(account -> account.getUserId()==userId)
                .toList();
    }
    public void depositAccount(long accountId,int moneyToTransfer){
        var account = findAccountById(accountId)
                .orElseThrow(
                        ()-> new IllegalArgumentException("No account with id %s was found"
                                .formatted(accountId)));

        if (moneyToTransfer<=0){
            throw new IllegalArgumentException("You can't deposit %d amount of money to your account!".formatted(moneyToTransfer));
        }
        account.setBalance(account.getBalance() + moneyToTransfer);
    }
}
