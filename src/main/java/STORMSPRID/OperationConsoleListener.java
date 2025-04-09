package STORMSPRID;

import STORMSPRID.account.AccountService;
import STORMSPRID.user.UserService;

import java.util.Scanner;

public class OperationConsoleListener {

    private Scanner scanner;
    private UserService userService;
    private AccountService accountService;

    public OperationConsoleListener(Scanner scanner,
                                    UserService userService,
                                    AccountService accountService) {

        this.scanner = scanner;
        this.userService = userService;
        this.accountService = accountService;
    }



    public void listenUpdates(){
        while(true){
            System.out.println("Type next operation:\n");
            String nextLine = scanner.nextLine();
            switch (nextLine) {
                case "USER_CREATE":
                    System.out.println("User created!");
                    break;
                case "ACCOUNT_CREATE":
                    System.out.println("Account created!");
                    break;
                default:
                    System.out.println("Invalid Operation");
            }
        }

    }


}
