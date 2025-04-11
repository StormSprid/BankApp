package STORMSPRID.operations.processors;

import STORMSPRID.account.Account;
import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.user.User;
import STORMSPRID.user.UserService;

import java.util.Scanner;

public class CloseAccountProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final AccountService accountService;
    private final UserService userService;

    public CloseAccountProcessor(Scanner scanner, AccountService accountService,UserService userService) {
        this.scanner = scanner;
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter accountId to close account with this id");
        int accountId = Integer.parseInt(scanner.nextLine());
        Account account = accountService.closeAccount(accountId);
        User user =
                userService
                        .findUserById(
                                account.getUserId())
                        .orElseThrow(
                                ()->new IllegalArgumentException("No such user with id=%s".
                                        formatted(account.getUserId())));
        user.getAccountList().remove(account);
        System.out.printf("Account successfully closed with id=%s".formatted(accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}
