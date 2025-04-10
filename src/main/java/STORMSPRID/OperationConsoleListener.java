package STORMSPRID;

import STORMSPRID.account.AccountService;
import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;
import STORMSPRID.user.UserService;

import java.util.Map;
import java.util.Scanner;


public class OperationConsoleListener {

    private Scanner scanner;
    private final Map<ConsoleOperationType, OperationCommandProcessor> processorMap;

    public OperationConsoleListener(
            Scanner scanner,
            Map<ConsoleOperationType, OperationCommandProcessor> processorMap) {

        this.scanner = scanner;

        this.processorMap = processorMap;
    }



    public void listenUpdates(){
        while(true){
            var operationType = listenNextOperation();
            processNextOperation(operationType);
        }

    }

    private ConsoleOperationType listenNextOperation() {
        System.out.println("Type next operation: ");
        while (true) {
            var nextOperation = scanner.nextLine();
            try {
                return ConsoleOperationType.valueOf(nextOperation);
            } catch (IllegalArgumentException e) {
                System.out.println("No such command found");
            }
        }
    }

    private void processNextOperation(ConsoleOperationType operationType){
        try{
            var processor  = processorMap.get(operationType);
            processor.processOperation();
            processNextOperation(operationType);

        } catch (Exception e) {
            System.out.printf("Error executing command:%s,error: %s%n",
                    operationType,
                    e.getMessage());
        }
    }

    private void processShowAllUsers(){

    }


    private void processUserCreate(){

    }

    private void processAccountCreate(){
       }




}
