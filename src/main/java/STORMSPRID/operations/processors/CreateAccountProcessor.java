package STORMSPRID.operations.processors;

import STORMSPRID.account.AccountService;
import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.user.UserService;

import java.util.Scanner;

public class CreateAccountProcessor implements OperationCommandProcessor {
    private final UserService userService;
    private final Scanner scanner;
    private final AccountService accountService;

    public CreateAccountProcessor(UserService userService,
                                  Scanner scanner,
                                  AccountService accountService) {
        this.userService = userService;
        this.scanner = scanner;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter user id to create an account to this user: \n");
        int userId = Integer.parseInt(scanner.nextLine());
        var user = userService.
                findUserById(userId).
                orElseThrow(
                        ()-> new IllegalArgumentException(
                                "No such user with id:%s".formatted(userId)
                        ));
        var account = accountService.createAccount(user);
        user.getAccountList().add(account);
        System.out.printf("Account successfully created: %s%n", account.toString());

    }
}
