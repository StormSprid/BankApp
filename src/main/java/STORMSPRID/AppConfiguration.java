package STORMSPRID;



import STORMSPRID.account.AccountService;
import STORMSPRID.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;


@Configuration
public class AppConfiguration {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
    @Bean
    public OperationConsoleListener operationConsoleListener(
            Scanner scanner,
            UserService userService,
            AccountService accountService
    ){
        return new OperationConsoleListener(scanner,
                 userService,
                 accountService);
    }
    @Bean
    public UserService userService(
            AccountService accountService
    ){
        return new UserService(accountService);
    }
    @Bean AccountService accountService(){
        return new AccountService();
    }
}
