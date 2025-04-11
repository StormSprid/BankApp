package STORMSPRID;



import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.operations.processors.CreateAccountProcessor;
import STORMSPRID.operations.processors.CreateUserProcessor;
import STORMSPRID.operations.processors.DepositAccountProcessor;
import STORMSPRID.operations.processors.ShowAllUsersProcessor;
import STORMSPRID.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


@Configuration
public class AppConfiguration {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
    @Bean
    public OperationConsoleListener operationConsoleListener(
            Scanner scanner,
            List<OperationCommandProcessor> commandProcessorList
    ){
        Map<ConsoleOperationType, OperationCommandProcessor> map =
                commandProcessorList
                        .stream()
                        .collect(Collectors.toMap(
                                OperationCommandProcessor::getOperationType,
                                processor->processor
                        ));
        return new OperationConsoleListener(scanner,map);
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
