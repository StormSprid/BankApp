package STORMSPRID.operations.processors;

import STORMSPRID.OperationConsoleListener;
import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.user.User;
import STORMSPRID.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Scanner;

@Configuration
public class OperationProcessorsConfiguration {



    @Bean
    public CreateUserProcessor createUserProcessor(
            Scanner scanner,
            UserService userService

    ){
        return new CreateUserProcessor(scanner,userService);
    }
    @Bean
    public CreateAccountProcessor createAccountProcessor(
             Scanner  scanner,
             UserService userService,
             AccountService accountService
    ){return  new CreateAccountProcessor(userService,scanner,accountService);}

    @Bean
    public ShowAllUsersProcessor showAllUsersProcessor(
            UserService userService
    ) {
        return new ShowAllUsersProcessor(userService);
    }
    @Bean public DepositAccountProcessor depositAccountProcessor(
            Scanner scanner,
            AccountService accountService){
        return new DepositAccountProcessor(scanner,accountService);
    }
}
