package STORMSPRID.operations.processors;

import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.user.User;
import STORMSPRID.user.UserService;

import java.util.Scanner;

public class CreateUserProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final UserService userService;

    public CreateUserProcessor(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter login for new user:\n");

        String login = scanner.nextLine();
        User user = userService.createUser(login);
        System.out.printf("User with login:%s was created!\n",login);
        System.out.println(user.toString());
    }
}
