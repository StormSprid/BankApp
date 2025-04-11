package STORMSPRID.operations.processors;

import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;

import java.util.Scanner;

public class DepositAccountProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final AccountService accountService;

    public DepositAccountProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter Account id: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Money to deposit: ");
        int money = Integer.parseInt(scanner.nextLine());
        accountService.depositAccount(accountId,money);
        System.out.printf("Successfully deposit %d to account with id:%s ".formatted(money,accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_DEPOSIT;
    }
}
