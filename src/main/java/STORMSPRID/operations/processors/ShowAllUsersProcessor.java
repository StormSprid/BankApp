package STORMSPRID.operations.processors;

import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.user.User;
import STORMSPRID.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShowAllUsersProcessor implements OperationCommandProcessor {
   private final UserService userService;

    public ShowAllUsersProcessor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void processOperation() {
        List<User> users = userService.getAllUsers();
        System.out.println("List of All Users: \n");
        users.forEach(System.out::println);
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.SHOW_ALL_USERS;
    }
}
