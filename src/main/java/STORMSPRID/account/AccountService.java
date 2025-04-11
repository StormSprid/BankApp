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
        System.out.println(idCounter);
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

    public void withdrawFromAccount(int accountId, int moneyToWithdraw) {
        var account = findAccountById(accountId)
                .orElseThrow(
                        ()-> new IllegalArgumentException("No account with id %s was found"
                                .formatted(accountId)));
        if (moneyToWithdraw<0){
            throw new IllegalArgumentException("You can't withdraw not positive amount of money");
        }

        if (account.getBalance() < moneyToWithdraw ){
            throw new IllegalArgumentException("You can't withdraw %d amount of money to your account with id=%s"
                    .formatted(moneyToWithdraw,accountId));
        }
        account.setBalance(account.getBalance() - moneyToWithdraw);
    }

    public Account closeAccount(int accountId) {
        var accountToRemove = findAccountById(accountId)
                .orElseThrow(
                        ()-> new IllegalArgumentException("No accountToRemove with id %s was found"
                                .formatted(accountId)));
        List<Account> accountList = getAllUserAccounts(accountToRemove.getUserId());
        if (accountList.size() ==1){
            throw new IllegalArgumentException("You can't close your accountToRemove bcs its single one");
        }
        Account accountToDeposit = accountList.stream().filter(it ->
                it.getId()!=accountId).findFirst()
                .orElseThrow();
        accountToDeposit.setBalance(accountToDeposit.getBalance() + accountToRemove.getBalance());
        accountMap.remove(accountId);
        return accountToRemove;
    }

    public void transfer(int fromAccountId, int toAccountId, int moneyToTransfer) {
        var fromAccount = findAccountById(fromAccountId)
                .orElseThrow(
                        ()-> new IllegalArgumentException("No accountToRemove with id %s was found"
                                .formatted(fromAccountId)));


        var toAccount = findAccountById(toAccountId)
                .orElseThrow(
                        ()-> new IllegalArgumentException("No accountToRemove with id %s was found"
                                .formatted(toAccountId)));

        if (moneyToTransfer<0){
            throw new IllegalArgumentException("You cant transfer not positive amount of money");
        }

        if (fromAccount.getBalance() < moneyToTransfer){
            throw new IllegalArgumentException(("You can't withdraw %d amount of money " +
                    "to your account with id=%s")
                    .formatted(moneyToTransfer,fromAccountId));
        }

    }
}
