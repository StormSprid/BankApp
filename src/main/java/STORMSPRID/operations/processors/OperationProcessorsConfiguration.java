package STORMSPRID.operations.processors;

import STORMSPRID.account.AccountService;
import STORMSPRID.user.User;
import STORMSPRID.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    ){return  new CreateAccountProcessor(userService,scanner,accountService);

    }
}
