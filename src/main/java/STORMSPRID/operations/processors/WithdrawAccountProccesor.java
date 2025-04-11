package STORMSPRID.operations.processors;

import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;

import java.util.Scanner;

public class WithdrawAccountProccesor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final AccountService accountService;

    public WithdrawAccountProccesor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }
    @Override
    public void processOperation() {
        System.out.println("Enter Account id: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Money to Withdraw: ");
        int money = Integer.parseInt(scanner.nextLine());
        accountService.withdrawFromAccount(accountId,money);
        System.out.printf("Successfully withdraw=-%d to account with id=%s ".formatted(money,accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_WITHDRAW;
    }
}
