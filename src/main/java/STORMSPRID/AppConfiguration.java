package STORMSPRID;



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
            Scanner scanner
    ){
        return new OperationConsoleListener(scanner);
    }
}
