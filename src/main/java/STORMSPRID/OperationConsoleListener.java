package STORMSPRID;

import STORMSPRID.account.AccountService;
import STORMSPRID.user.User;
import STORMSPRID.user.UserService;

import java.util.Scanner;
import java.util.List;

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
            var operationType = listenNextOperation();
            try{
                processNextOperation(operationType);

            } catch (Exception e) {
                System.out.printf("Error executing command:%s,error: %s%n",
                        operationType,
                        e.getMessage());
            }
        }

    }

    private String listenNextOperation() {
        System.out.println("Type next operation:\n");
        return scanner.nextLine();
    }

    private void processNextOperation(String operation){


        switch (operation) {
            case "USER_CREATE":
                processUserCreate();
                break;
            case "SHOW_ALL_USERS":
                processShowAllUsers();
                break;

            case "ACCOUNT_CREATE":
                processAccountCreate();
                break;


            default:
                System.out.println("Invalid Operation");
        }
    }

    private void processShowAllUsers(){
        List<User> users = userService.getAllUsers();
        System.out.println("List of All Users: \n");
        users.forEach(System.out::println);
    }


    private void processUserCreate(){
        System.out.println("Enter login for new user:\n");
        String login = scanner.nextLine();
        User user = userService.createUser(login);
        System.out.printf("User with login:%s was created!\n",login);
        System.out.println(user.toString());
    }

    private void processAccountCreate(){
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
