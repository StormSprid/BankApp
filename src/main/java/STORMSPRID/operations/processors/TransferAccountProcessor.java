package STORMSPRID.operations.processors;

import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class TransferAccountProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final AccountService accountService;

    public TransferAccountProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter source account id: ");
        int fromAccountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter destination account id: ");
        int toAccountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to transfer: ");
        int moneyToTransfer = Integer.parseInt(scanner.nextLine());
        accountService.transfer(fromAccountId,toAccountId,moneyToTransfer);
        System.out.printf(
                ("Money successfully transferred from accountId=%s," +
                        "to accountId=%s with amount of money =%s")
                .formatted(fromAccountId,toAccountId,moneyToTransfer));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_TRANSFER;
    }
}
